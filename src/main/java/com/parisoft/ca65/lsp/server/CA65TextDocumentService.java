package com.parisoft.ca65.lsp.server;

import com.parisoft.ca65.lsp.parser.CodeParser;
import com.parisoft.ca65.lsp.parser.symbol.Definition;
import com.parisoft.ca65.lsp.parser.symbol.Reference;
import com.parisoft.ca65.lsp.parser.symbol.Symbol;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.DeclarationParams;
import org.eclipse.lsp4j.DefinitionParams;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.singletonList;
import static java.util.Comparator.comparingInt;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

public class CA65TextDocumentService implements TextDocumentService {

    private static final Logger log = LoggerFactory.getLogger(CA65TextDocumentService.class);

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> declaration(DeclarationParams params) {
        log.debug("declaration({})", params);
        return supplyAsync(() -> {
            Location location = new Location(params.getTextDocument().getUri(),
                                             new Range(
                                                     new Position(0, 0),
                                                     new Position(0, 3)));
            return Either.forLeft(singletonList(location));
        });
    }

    @Override
    public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(DefinitionParams params) {
        log.debug("definition({})", params);

        Path path = Paths.get(URI.create(params.getTextDocument().getUri())).normalize();
        Position position = params.getPosition();
        Definition definition = Symbol.Table.references(path)
                .filter(ref -> ref.match(position))
                .map(Reference::getDefinition)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);

        if (definition != null) {
            return supplyAsync(() -> Either.forLeft(singletonList(definition.toLocation())));
        }

        return supplyAsync(() -> Either.forLeft(emptyList()));
    }

    @Override
    public CompletableFuture<List<? extends Location>> references(ReferenceParams params) {
        log.debug("references({})", params);


        Path path = Paths.get(URI.create(params.getTextDocument().getUri())).normalize();
        Position position = params.getPosition();
        Definition definition = Symbol.Table.definitions(path).filter(def -> def.match(position)).findFirst().orElse(null);

        if (definition == null) {
            definition = Symbol.Table.references(path)
                    .filter(ref -> ref.match(position))
                    .map(Reference::getDefinition)
                    .findFirst()
                    .orElse(null);
        }

        if (definition != null) {
            Definition def = definition;
            List<Location> locations = Symbol.Table.references()
                    .filter(ref -> def.equals(ref.getDefinition()))
                    .map(Symbol::toLocation)
                    .collect(toList());
            return supplyAsync(() -> locations);
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
        Path path = Paths.get(URI.create(params.getTextDocument().getUri())).normalize();
        new CodeParser(code, path).parse();
    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {
        log.debug("didChange({})", params);
        Path path = Paths.get(URI.create(params.getTextDocument().getUri())).normalize();

        for (TextDocumentContentChangeEvent change : params.getContentChanges()) {
            new CodeParser(change.getText(), path).parse();
        }
    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {

    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {

    }
}
