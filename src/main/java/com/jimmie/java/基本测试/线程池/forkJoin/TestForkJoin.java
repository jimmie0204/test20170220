package com.jimmie.java.基本测试.线程池.forkJoin;

/**
 * @author jimmie
 * @create 2020-04-09 下午6:59
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * 练习使用fork-join
 * 结论：pool公用的时候，受并行度控制，超出并行度线程等待。fork-join的最大线程数就是并行度。
 *
 * @author Owen
 * create time:2018/9/23 11:49
 */
public class TestForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(30);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println("poolSize==="+forkJoinPool.getPoolSize());

        BatchInsertTask batchInsertTask = new BatchInsertTask(list);
        long t1 = System.currentTimeMillis();
        ForkJoinTask<Integer> reslut = forkJoinPool.submit(batchInsertTask);
        System.out.println("poolSize==="+forkJoinPool.getPoolSize());
        System.out.println(reslut.get());
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println("poolSize==="+forkJoinPool.getPoolSize());

        //新任务测试
        JimmieForkJoinTask jimmieForkJoinTask = new JimmieForkJoinTask(list, 4);
        jimmieForkJoinTask.setForkJoinTaskHandler(new ForkJoinTaskHandler<Integer,String>() {
            @Override
            public String merge(String aTaskResult, String bTaskResult) {
                return aTaskResult+"\n"+bTaskResult;
            }

            @Override
            public String handle(List<Integer> datas) {
                try {
                    System.out.println("poolSize==="+forkJoinPool.getPoolSize());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("jimmieForkJoinTask=="+Thread.currentThread().getName()+"线程处理个数："+datas.size()+"个");
                return "done";
            }
        });

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        JimmieForkJoinTask jimmieForkJoinTask2 = new JimmieForkJoinTask(list2, 1);
        jimmieForkJoinTask2.setForkJoinTaskHandler(new ForkJoinTaskHandler<Integer,String>() {
            @Override
            public String merge(String aTaskResult, String bTaskResult) {
                return aTaskResult+"\n"+bTaskResult;
            }

            @Override
            public String handle(List<Integer> datas) {
                try {
                    System.out.println("poolSize==="+forkJoinPool.getPoolSize());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("jimmieForkJoinTask2=="+Thread.currentThread().getName()+"线程处理个数："+datas.size()+"个");
                return "done";
            }
        });



        long t3 = System.currentTimeMillis();
        ForkJoinTask<Integer> reslut2 = forkJoinPool.submit(jimmieForkJoinTask);
        ForkJoinTask<Integer> reslut3 = forkJoinPool.submit(jimmieForkJoinTask2);

        System.out.println("poolSize==="+forkJoinPool.getPoolSize());
        System.out.println(reslut2.get());
        long t4 = System.currentTimeMillis();
        System.out.println(t4-t3);


        System.in.read();
    }
}