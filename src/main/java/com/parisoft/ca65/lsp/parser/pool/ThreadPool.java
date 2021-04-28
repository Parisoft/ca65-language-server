package com.parisoft.ca65.lsp.parser.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static ExecutorService newThreadPool() {
        return new ThreadPoolExecutor(1, 1, 100, TimeUnit.MILLISECONDS, new ParseQueue());
    }
}
