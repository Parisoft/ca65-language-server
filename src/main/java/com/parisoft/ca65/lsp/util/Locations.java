package com.parisoft.ca65.lsp.util;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class Locations {

    public static CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> toFutureList(Location location) {
        return supplyAsync(() -> Either.forLeft(singletonList(location)));
    }

    public static CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> toFutureList(LocationLink location) {
        return supplyAsync(() -> Either.forRight(singletonList(location)));
    }

    public static CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> empty() {
        return supplyAsync(() -> Either.forRight(emptyList()));
    }
}
