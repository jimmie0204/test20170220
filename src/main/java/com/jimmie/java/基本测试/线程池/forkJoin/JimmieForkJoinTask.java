package com.jimmie.java.基本测试.线程池.forkJoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author jimmie
 * @create 2020-04-09 下午6:52
 */
public class JimmieForkJoinTask<I, V> extends RecursiveTask<V> {

    public List<I> datas;

    public Integer limit;

    public ForkJoinTaskHandler<I, V> forkJoinTaskHandler;

    public JimmieForkJoinTask() {
    }

    public JimmieForkJoinTask(List<I> datas, Integer limit) {
        this.datas = datas;
        this.limit = limit;
    }

    public JimmieForkJoinTask(List<I> datas, Integer limit, ForkJoinTaskHandler<I, V> forkJoinTaskHandler) {
        this.datas = datas;
        this.limit = limit;
        this.forkJoinTaskHandler = forkJoinTaskHandler;
    }

    @Override
    protected V compute() {
        if (datas.size() <= limit) {
            return doTask(datas);
        } else {
            int size = datas.size();

            //第一个分组
            JimmieForkJoinTask aTask = new JimmieForkJoinTask(datas.subList(0, size / 2), limit, forkJoinTaskHandler);
            //第二个分组
            JimmieForkJoinTask bTask = new JimmieForkJoinTask(datas.subList(size / 2, datas.size()), limit, forkJoinTaskHandler);
            //两个任务并发执行起来
            invokeAll(aTask, bTask);
            //两个分组的结果做合并

            V aTaskResult = (V) aTask.join();
            V bTaskResult = (V) bTask.join();
            return forkJoinTaskHandler.merge(aTaskResult, bTaskResult);
        }
    }

    private V doTask(List<I> datas) {
        return forkJoinTaskHandler.handle(datas);
    }

    public List<I> getDatas() {
        return datas;
    }

    public void setDatas(List<I> datas) {
        this.datas = datas;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public ForkJoinTaskHandler<I, V> getForkJoinTaskHandler() {
        return forkJoinTaskHandler;
    }

    public void setForkJoinTaskHandler(ForkJoinTaskHandler<I, V> forkJoinTaskHandler) {
        this.forkJoinTaskHandler = forkJoinTaskHandler;
    }
}
