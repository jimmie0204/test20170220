package com.jimmie.java.基本测试.线程池;/**
 * Created by jimmie on 2018/3/9.
 */

import java.util.concurrent.*;

/**
 * @author jimmie
 * @create 2018-03-09 下午6:44
 */

public class ForkJoinDemo {

    /**
     * how to find the max number in array by Fork/Join
     */
    private static class MaxNumber extends RecursiveTask<Integer> {

        private int threshold = 2;

        private int[] array; // the data array

        private int index0 = 0;
        private int index1 = 0;

        public MaxNumber(int[] array, int index0, int index1) {
            this.array = array;
            this.index0 = index0;
            this.index1 = index1;
        }

        @Override
        protected Integer compute() {
            System.out.println("current thread==="+Thread.currentThread().hashCode());
            int max = Integer.MIN_VALUE;
            if ((index1 - index0) <= threshold) {

                for (int i = index0;i <= index1; i ++) {
                    max = Math.max(max, array[i]);
                }

            } else {
                //fork/join
                System.out.println("开始切分任务===");
                int mid = index0 + (index1 - index0) / 2;
                MaxNumber lMax = new MaxNumber(array, index0, mid);
                MaxNumber rMax = new MaxNumber(array, mid + 1, index1);

                lMax.fork();
                rMax.fork();

                int lm = lMax.join();
                int rm = rMax.join();

                max = Math.max(lm, rm);

            }

            return max;
        }
    }

    public static void main(String ... args) throws ExecutionException, InterruptedException, TimeoutException {

        ForkJoinPool pool = new ForkJoinPool();

        int[] array = {100,400,200,90,80,300,600,10,20,-10,30,2000,1000};

        MaxNumber task = new MaxNumber(array, 0, array.length - 1);

        Future<Integer> future = pool.submit(task);

        System.out.println("Result:" + future.get(1, TimeUnit.SECONDS));

    }

}
