package com.luo.demo7executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
        //目标：ExecutorService线程池的的创建方案二
        //使用线程池的实现类ThreadPoolExecutor声明七个参数来创建线程池对象
        ExecutorService es = new ThreadPoolExecutor(3,   //线程池中核心线程数
                5,                                                  //线程池中最大线程数
                10, TimeUnit.SECONDS,                              //线程的存活时间
                new ArrayBlockingQueue<>(3),      //linkedBlockingQueue，任务队列
                Executors.defaultThreadFactory(),                 //调用Executors.工具类创建线程工厂对象//或者直接创建使用匿名内部类传入
                new ThreadPoolExecutor.DiscardOldestPolicy()     //线程池的拒绝策略//或者new ThreadPoolExecutor.AbortPolicy()
        );

        //2，使用线程池处理Callable任务

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
