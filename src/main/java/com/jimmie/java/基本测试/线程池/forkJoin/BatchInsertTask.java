package com.jimmie.java.基本测试.线程池.forkJoin;

/**
 * @author jimmie
 * @create 2020-04-09 下午6:58
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * 批量插入数据任务类
 * 利用fork-join框架对数据插入任务进行分组，变成分组插入
 *
 * @author Owen
 * create time:2018/9/23 11:49
 */
public class BatchInsertTask extends RecursiveTask<Integer> {
    //要插入的数据
    List<Integer> records;

    public BatchInsertTask(List<Integer> records) {
        this.records = records;
    }

    @Override
    protected Integer compute() {
        //当要插入的数据少于3，则直接插入
        if (records.size() < 3) {
            return computeDirectly();
        } else {
            //如果要插入的数据大于等于3，则进行分组插入
            int size = records.size();

            //第一个分组
            BatchInsertTask aTask = new BatchInsertTask(records.subList(0, size / 2));
            //第二个分组
            BatchInsertTask bTask = new BatchInsertTask(records.subList(size / 2, records.size()));
            //两个任务并发执行起来
            invokeAll(aTask, bTask);
            //两个分组的插入的行数加起来
            return aTask.join() + bTask.join();
        }
    }

    /**
     * 真正插入数据的逻辑
     */
    private int computeDirectly() {
        /*try {
            Thread.sleep((long) (records.size() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("线程"+Thread.currentThread().getName()+"插入了：" + Arrays.toString(records.toArray()));
        return records.size();
    }
}
