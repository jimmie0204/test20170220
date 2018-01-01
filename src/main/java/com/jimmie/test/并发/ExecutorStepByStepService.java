package com.jimmie.test.并发;

import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;

public class ExecutorStepByStepService<V>{

	private final Vector<RunnableFuture<V>> vec ;
    private final Executor executor;

    /**
     * FutureTask extension to enqueue upon completion
     */
    private class StepByStepFuture extends FutureTask<V> {
        StepByStepFuture(RunnableFuture<V> task) {
            super(task, null);
            this.task = task;
        }
        private final RunnableFuture<V> task;
//        protected void done() { vec.add(task); }

    }

    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        return new FutureTask<V>(task);
    }

    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        return new FutureTask<V>(task, result);
    }

    /**
     * Creates an ExecutorStepByStepService using the supplied
     * executor for base task execution and a
     * {@link LinkedBlockingQueue} as a completion queue.
     *
     * @param executor the executor to use
     * @throws NullPointerException if executor is {@code null}
     */
    public ExecutorStepByStepService(Executor executor) {
        if (executor == null)
            throw new NullPointerException();
        this.executor = executor;
        this.vec = new Vector<RunnableFuture<V>>();
    }

    /**
     * Creates an ExecutorStepByStepService using the supplied
     * executor for base task execution and the supplied queue as its
     * completion queue.
     *
     * @param executor the executor to use
     * @param completionQueue the queue to use as the completion queue
     *        normally one dedicated for use by this service. This
     *        queue is treated as unbounded -- failed attempted
     *        {@code Queue.add} operations for completed taskes cause
     *        them not to be retrievable.
     * @throws NullPointerException if executor or completionQueue are {@code null}
     */
    public ExecutorStepByStepService(Executor executor,
    		Vector<RunnableFuture<V>> vec) {
        if (executor == null || vec == null)
            throw new NullPointerException();
        this.executor = executor;
        this.vec = vec;
    }

    public Future<V> submit(Callable<V> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task);
//        System.out.println(f);
        vec.add(f);
        executor.execute(new StepByStepFuture(f));
        return f;
    }

    public Future<V> submit(Runnable task, V result) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task, result);
        vec.add(f);
        executor.execute(new StepByStepFuture(f));
        return f;
    }

    public Future<V> take(int i) throws InterruptedException {
        return vec.get(i);
    }


    
    
    
	
}
