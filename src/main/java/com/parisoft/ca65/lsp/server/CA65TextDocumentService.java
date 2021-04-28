package com.parisoft.ca65.lsp.server;

import com.parisoft.ca65.lsp.parser.CodeParser;
import com.parisoft.ca65.lsp.parser.symbol.Definition;
import com.parisoft.ca65.lsp.parser.symbol.Include;
import com.parisoft.ca65.lsp.parser.symbol.Reference;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
import com.parisoft.ca65.lsp.util.Locations;
import com.parisoft.ca65.lsp.util.Paths;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.DefinitionParams;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

public class CA65TextDocumentService implements TextDocumentService {

    private static final Logger log = LoggerFactory.getLogger(CA65TextDocumentService.class);

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(DefinitionParams params) {
        log.debug("definition({})", params);

        Path path = Paths.fromURI(params.getTextDocument().getUri());
        Position position = params.getPosition();

        return Symbol.Table.includes(path)
                .parallel()
                .filter(inc -> inc.match(position))
                .map(Include::toLocationLink)
                .map(Locations::toFutureList)
                .findFirst()
                .orElse(Symbol.Table.references()
                                .parallel()
                                .filter(ref -> ref.match(path, position))
                                .map(Reference::getDefinition)
                                .filter(Objects::nonNull)
                                .map(Symbol::toLocation)
                                .map(Locations::toFutureList)
                                .findFirst()
                                .orElse(Symbol.Table.definitions()
                                                .parallel()
                                                .filter(def -> def.match(path, position))
                                                .map(Symbol::toLocation)
                                                .map(Locations::toFutureList)
                                                .findFirst()
                                                .orElse(Locations.empty())));
    }

    @Override
    public CompletableFuture<List<? extends Location>> references(ReferenceParams params) {
        log.debug("references({})", params);

        Path path = Paths.fromURI(params.getTextDocument().getUri());
        Position position = params.getPosition();
        Definition definition = Symbol.Table.definitions()
                .parallel()
                .filter(def -> def.match(path, position))
                .findFirst()
                .orElse(Symbol.Table.references()
                                .parallel()
                                .filter(ref -> ref.match(path, position))
                                .map(Reference::getDefinition)
                                .filter(Objects::nonNull)
                                .findFirst()
                                .orElse(null));

        if (definition != null) {
            return supplyAsync(() -> Symbol.Table.references()
                    .parallel()
                    .filter(definition::isDefinitionOf)
                    .map(Symbol::toLocation)
                    .collect(toList()));
        }

        return supplyAsync(Collections::emptyList);
    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams position) {
        log.debug("completion({})", position);
        return CompletableFuture.supplyAsync(() -> {
            List<CompletionItem> completionItems = new ArrayList<>();
            try {
                // Sample Completion item for sayHello
                CompletionItem completionItem = new CompletionItem();
                // Define the text to be inserted in to the file if the completion item is selected.
                completionItem.setInsertText("sayHello() {\n    print(\"hello\")\n}");
                // Set the label that shows when the completion drop down appears in the Editor.
                completionItem.setLabel("sayHello()");
                // Set the completion kind. This is a snippet.
                // That means it replace character which trigger the completion and
                // replace it with what defined in inserted text.
                completionItem.setKind(CompletionItemKind.Snippet);
                // This will set the details for the snippet code which will help user to
                // understand what this completion item is.
                completionItem.setDetail("sayHello()\n this will say hello to the people");

                // Add the sample completion item to the list.
                completionItems.add(completionItem);
            } catch (Exception e) {
                //TODO: Handle the exception.
            }

            // Return the list of completion items.
            return Either.forLeft(completionItems);
        });
    }

    @Override
    public void didOpen(DidOpenTextDocumentParams params) {
        log.debug("didOpen({})", params);
        String code = params.getTextDocument().getText();
        Path path = Paths.fromURI(params.getTextDocument().getUri());
        new CodeParser(code, path).asyncParse();
    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {
        log.debug("didChange({})", params);
        Path path = Paths.fromURI(params.getTextDocument().getUri());

        for (TextDocumentContentChangeEvent change : params.getContentChanges()) {
            new CodeParser(change.getText(), path).asyncParse();
        }
    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {

    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {
        log.debug("didSave({})", params);
    }
}
