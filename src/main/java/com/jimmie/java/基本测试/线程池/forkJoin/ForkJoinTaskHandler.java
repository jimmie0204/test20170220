package com.jimmie.java.基本测试.线程池.forkJoin;

import java.util.List;

/**
 * @author jimmie
 * @create 2020-04-09 下午7:12
 */
public interface ForkJoinTaskHandler<I,V> {

    public V merge(V aTaskResult, V bTaskResult);

    public V handle(List<I> datas);
}
