package com.luo.demo7executorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//使用Executors可能存在的风险

/**
 * 大型并发系统环境中使用Executors如果不注意可能会出现系统风险
 * 在阿里的java开发手册中是不予许使用Executors工具类创建线程池的，只能通过实现类ThreadPoolExecutor创建
 * Executors返回的线程池对象弊端如下
 * 1）FixedThreadPool和SingleThreadPool:
 * 允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM
 * 2）CachedThreadPool和ScheduledThreadPool:
 * 允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM
 */
public class ExecutorsDemo3 {

    //我的cpu的核数16
    public static void main(String[] args) {

        //目标：使用Java提供的线程池工具类Executors创建线程池，调用其静态方法直接得到线程池
        ExecutorService es = Executors.newFixedThreadPool(5);//创建一个固定线程数量的线程池
        //这些工具类底层都是调用之前学习的线程池实现类 ThreadPoolExecutor来创建
        //线程池后续用法与之前一致
        //2，使用线程池处理任务，看会不会复用线程
        Runnable task = new MyRunnable();//任务可以复用
        es.execute(  task);//提交第一个任务，创建线程，自动启动线程处理这个任务
        es.execute(  task);//提交第二个任务
        es.execute(  task);//提交第三个任务

        Future<String> s1 = es.submit(new MyCallable(123));

        Future<String> s2 = es.submit(new MyCallable(456));

        Future<String> s3 = es.submit(new MyCallable(789));

        try {
            System.out.println(s1.get());
            System.out.println(s2.get());
            System.out.println(s3.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
/**
 * 多线程是并发和并行同时执行的
 * 并行：多个任务同时刻执行，比如cpu同时执行多个任务
 * 并发：多个任务交替执行，比如cpu执行多个任务
 */