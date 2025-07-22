package com.luo.demo1threadCreate;

public class ThreadCreateDemo2_2 {
    public static void main(String[] args) {
        //目标：runnable接口实现多线程，使用匿名内部类简化写法


        //3.创建线程实现类的对象
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    System.out.println("副线程任务代码" + i);
                }


            }
        };

        //4.把线程任务对象交给线程对象包装

        Thread t1 = new Thread(r1);// public Thread(Runnable task)
        //5.启动线程
        t1.start();
        //更加简化的写法，直接链式编程

       new Thread(new Runnable() {//还可以使用lambda简化，因为这是一个函数式接口的匿名内部类
           @Override
           public void run() {
               for (int i = 0; i < 4; i++) {
                   System.out.println("子线程任务代码" + i);
               }
           }
       }).start();

       //lambda简化
       new Thread(() -> {
           for (int i = 0; i < 4; i++) {
               System.out.println("子线程任务2代码" + i);
           }
       }).start();

        //主线程任务

        for (int i = 0; i < 4; i++) {
            System.out.println("主线程任务代码" + i);
        }

    }
}
