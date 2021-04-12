package com.parisoft.ca65.lsp.launcher;

import com.parisoft.ca65.lsp.server.CA65LanguageServer;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Launcher for hello language server.
 */
public class StdioLauncher {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // As we are using system std io channels
        // we need to reset and turn off the logging globally
        // So our client->server communication doesn't get interrupted.
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(Level.OFF);

        // start the language server
        startServer();
    }

    /**
     * Start the language server.
     *
     * @throws ExecutionException   Unable to start the server
     * @throws InterruptedException Unable to start the server
     */
    private static void startServer() throws ExecutionException, InterruptedException {
        // Initialize the HelloLanguageServer
        CA65LanguageServer languageServer = new CA65LanguageServer();
        // Create JSON RPC launcher for HelloLanguageServer instance.
        Launcher<LanguageClient> launcher = LSPLauncher.createServerLauncher(languageServer, System.in, System.out);

        // Get the client that request to launch the LS.
        LanguageClient client = launcher.getRemoteProxy();

        // Set the client to language server
        languageServer.connect(client);

        // Start the listener for JsonRPC
        Future<?> startListening = launcher.startListening();

        // Get the computed result from LS.
        startListening.get();
    }
}
