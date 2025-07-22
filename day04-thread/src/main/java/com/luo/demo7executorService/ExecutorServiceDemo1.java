package com.luo.demo7executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        //目标：ExecutorService线程池的的创建方案一
        //使用线程池的实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ExecutorService es = new ThreadPoolExecutor(3,   //线程池中核心线程数
                5,                                                  //线程池中最大线程数
                10, TimeUnit.SECONDS,                              //线程的存活时间
                new ArrayBlockingQueue<>(3),      //linkedBlockingQueue，任务队列
                Executors.defaultThreadFactory(),                 //调用Executors.工具类创建线程工厂对象//或者直接创建使用匿名内部类传入
                new ThreadPoolExecutor.DiscardOldestPolicy()     //线程池的拒绝策略//或者new ThreadPoolExecutor.AbortPolicy()
        );

        //2，使用线程池处理任务，看会不会复用线程
        Runnable task = new MyRunnable();//任务可以复用
        es.execute(  task);//提交第一个任务，创建线程，自动启动线程处理这个任务
        es.execute(  task);//提交第二个任务
        es.execute(  task);//提交第三个任务
        es.execute(  task);//复用线程
        es.execute(  task);
        es.execute(  task);//填满第三个任务队列
        es.execute(  task);//到达临时线程的创建时机
        es.execute(  task);//到达临时线程的创建时机，到达线程上限
        es.execute(  task);//到了任务拒绝策略



        //3.关闭线程池//一般不关闭线程池，让线程池长久存活
       // es.shutdown();//等所有任务执行完毕，再关闭线程池
        //es.shutdownNow();//立即关闭线程池，并打断正在执行的任务



        //什么时候创建临时线程
        //1.新任务提交时发现核心线程都被占用，并且任务队列也满了，而且还可以创建临时线程，才会创建临时线程处理任务

        //什么时候拒绝新任务
        //1.新任务提交时发现核心线程和临时线程都被占用，并且任务队列也满了，而且临时线程也满了，才会拒绝新任务



    }
}
