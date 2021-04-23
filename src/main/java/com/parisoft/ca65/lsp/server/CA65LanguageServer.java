package com.parisoft.ca65.lsp.server;

import org.eclipse.lsp4j.CompletionOptions;
import org.eclipse.lsp4j.DeclarationRegistrationOptions;
import org.eclipse.lsp4j.DefinitionOptions;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.ServerInfo;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.TextDocumentSyncOptions;
import org.eclipse.lsp4j.WorkspaceFoldersOptions;
import org.eclipse.lsp4j.WorkspaceServerCapabilities;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

public class CA65LanguageServer implements LanguageServer, LanguageClientAware {

    private static final Logger log = LoggerFactory.getLogger(CA65LanguageServer.class);

    private static final String NAME = "ca65 Language Server Provider";

    public static List<Path> workspaceDir = singletonList(Paths.get("").toAbsolutePath().normalize());

    private TextDocumentService textDocumentService;
    private WorkspaceService workspaceService;
    private LanguageClient client;
    private int errorCode = 1;

    public CA65LanguageServer() {
        this.textDocumentService = new CA65TextDocumentService();
        this.workspaceService = new CA65WorkspaceService();
    }

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        if (params.getWorkspaceFolders() != null) {
            workspaceDir = params.getWorkspaceFolders()
                    .stream()
                    .map(folder -> URI.create(folder.getUri()))
                    .map(Paths::get)
                    .collect(toList());
        }

        // Set the capabilities of the LS to inform the client.
        WorkspaceFoldersOptions workspaceFoldersOptions = new WorkspaceFoldersOptions();
        workspaceFoldersOptions.setSupported(true);
        ServerCapabilities capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Full);
        capabilities.setWorkspace(new WorkspaceServerCapabilities(workspaceFoldersOptions));
        capabilities.setDeclarationProvider(true);
        capabilities.setDefinitionProvider(true);
        capabilities.setReferencesProvider(true);
//        capabilities.setCompletionProvider(new CompletionOptions());

        ServerInfo info = new ServerInfo(NAME);

        log.info("{} Started", NAME);

        return supplyAsync(() -> new InitializeResult(capabilities, info));
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        // If shutdown request comes from client, set the error code to 0.
        log.info("Bye");
        errorCode = 0;
        return null;
    }

    @Override
    public void exit() {
        // Kill the LS on exit request from client.
        log.info("Bye");
        System.exit(errorCode);
    }

    @Override
    public TextDocumentService getTextDocumentService() {
        // Return the endpoint for language features.
        return this.textDocumentService;
    }

    @Override
    public WorkspaceService getWorkspaceService() {
        // Return the endpoint for workspace functionality.
        return this.workspaceService;
    }

    @Override
    public void connect(LanguageClient languageClient) {
        // Get the client which started this LS.
        this.client = languageClient;
    }
}
