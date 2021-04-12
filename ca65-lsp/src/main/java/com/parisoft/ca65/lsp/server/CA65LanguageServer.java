package com.parisoft.ca65.lsp.server;

import org.eclipse.lsp4j.CompletionOptions;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class CA65LanguageServer implements LanguageServer, LanguageClientAware {

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
        // Initialize the InitializeResult for this LS.
        final InitializeResult result = new InitializeResult(new ServerCapabilities());

        // Set the capabilities of the LS to inform the client.
        result.getCapabilities().setTextDocumentSync(TextDocumentSyncKind.Full);
        CompletionOptions completionOptions = new CompletionOptions();
        result.getCapabilities().setCompletionProvider(completionOptions);

        return supplyAsync(() -> result);
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        // If shutdown request comes from client, set the error code to 0.
        errorCode = 0;
        return null;
    }

    @Override
    public void exit() {
        // Kill the LS on exit request from client.
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
