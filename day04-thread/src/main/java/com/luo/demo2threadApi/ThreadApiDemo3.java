package com.luo.demo2threadApi;

public class ThreadApiDemo3 {
    public static void main(String[] args) {
        //目标：了解线程常用的使用方法三：join方法（线程插队），让调用这个方法的线程先执行完毕

        MyThread1 t1 = new MyThread1("线程1");
        MyThread1 t2 = new MyThread1("线程2");


        t1.start();

        t2.start();

        //主线程
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName()+"输出："+i);
            if (i == 2){
                try {
                    t2.join();//线程插队让t2先执行完毕，然后再执行主线程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class MyThread1 extends Thread{
    public MyThread1() {
    }
    public MyThread1(String a) {
        super(a);//调用的父类的有参构造器


    }

    @Override
    public void run() {
        //线程要执行的任务
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName()+"输出："+i);
        }
    }
}
