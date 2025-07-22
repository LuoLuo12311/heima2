package com.luo.demo1threadCreate;

public class ThreadCreateDemo2 {
    public static void main(String[] args) {
        //目标：掌握多线程的创建方式二，实现Runnable接口来创建

        //3.创建线程实现类的对象
        Runnable r1 = new MyRunnable();//多态写法//只是线程任务而不是线程

        //4.把线程任务对象交给线程对象包装

        Thread t1 = new Thread(r1, "线程1");// public Thread(Runnable task)
        //5.启动线程
        t1.start();

        //主线程任务

        for (int i = 0; i < 4; i++) {
            System.out.println("主线程任务代码" + i);
        }

    }
}

//1.定义一个线程任务类，实现Runnable接口

class MyRunnable implements Runnable{
    //2.重写run方法，设置线程任务
    @Override
    public void run() {
        //线程任务代码
        for (int i = 0; i < 4; i++) {
            System.out.println("副线程任务代码" + i);
        }
    }
}
