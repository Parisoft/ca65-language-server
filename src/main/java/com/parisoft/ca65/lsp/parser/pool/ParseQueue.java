package com.parisoft.ca65.lsp.parser.pool;

import com.parisoft.ca65.lsp.parser.CodeParser;

import java.lang.reflect.Field;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("NullableProblems")
public class ParseQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable> {

    private final ReentrantLock locker = new ReentrantLock(true);
    private final Condition notEmpty = locker.newCondition();
    private final List<CodeParser> parsers = new ArrayList<>();

    private boolean enqueue(CodeParser codeParser) {
        for (int i = 0; i < parsers.size(); i++) {
            if (parsers.get(i).getPath().equals(codeParser.getPath())) {
                parsers.set(i, codeParser);
                notEmpty.signal();

                return true;
            }
        }

        notEmpty.signal();

        return parsers.add(codeParser);
    }

    @Override
    public boolean offer(Runnable runnable) {
        locker.lock();

        try {
            if (runnable instanceof CodeParser) {
                return enqueue((CodeParser) runnable);
            } else if (runnable instanceof FutureTask) {
                try {
                    Field callable = FutureTask.class.getDeclaredField("callable");
                    callable.setAccessible(true);
                    Object o = callable.get(runnable);
                    Field task = o.getClass().getDeclaredField("task");
                    task.setAccessible(true);
                    CodeParser parser = (CodeParser) task.get(o);
                    enqueue(parser);
                } catch (NoSuchFieldException | IllegalAccessException ignored) {

                }
            }

            return false;
        } finally {
            locker.unlock();
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        locker.lockInterruptibly();

        try {
            while (parsers.isEmpty()) {
                notEmpty.await();
            }

            return parsers.remove(0);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        locker.lockInterruptibly();

        try {
            while (parsers.isEmpty()) {
                if ((nanos = notEmpty.awaitNanos(nanos)) <= 0) {
                    return null;
                }
            }

            return parsers.remove(0);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        locker.lock();

        try {
            return parsers.remove(o);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public int size() {
        return parsers.size();
    }

    @Override
    public Iterator<Runnable> iterator() {
        return null;
    }

    @Override
    public void put(Runnable runnable) throws InterruptedException {

    }

    @Override
    public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c, int maxElements) {
        return 0;
    }

    @Override
    public Runnable poll() {
        return null;
    }

    @Override
    public Runnable peek() {
        return null;
    }
}
