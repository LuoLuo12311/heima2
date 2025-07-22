package com.luo.demo7executorService;

//1.定义一个线程任务类，实现Runnable接口

import lombok.SneakyThrows;

public class MyRunnable implements Runnable{
    //2.重写run方法，设置线程任务
    @Override
    public void run() {
        //线程任务代码
        for (int i = 0; i < 4; i++) {
            System.out.println( Thread.currentThread().getName()+"输出" + i);
            try {
                Thread.sleep(Integer.MAX_VALUE);//人为制造线程堵塞
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
