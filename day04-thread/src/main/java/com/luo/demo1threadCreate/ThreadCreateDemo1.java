package com.luo.demo1threadCreate;

public class ThreadCreateDemo1 {
    //main方法本身是由一条主线程负责推进执行
    public static void main(String[] args) {
        //目标：认识线程，创建线程的方式一

        //4.创建一个线程对象代表一个线程
        Thread t1 = new MyThread();//多态写法
        //5.调用start方法开启线程，调用start方法会自动调用重写的run方法
        //不能直接调用run方法
        t1.start();//启动线程，然后让线程执行run方法
        //注意：不要把主线程任务放在启动子线程之前，不然会直接跑完主线程，变成一种单线程的效果

        //主线程任务
        for (int i = 0; i < 4; i++) {
            System.out.println("主线程："+i);
        }
    }
}
//1.定义一个子类继承Thread类就可以成为一个线程类

class MyThread extends Thread{
    //2.重写继承的run方法
    @Override
    public void run() {
        //3.在重写的run方法中编写线程要执行的任务
        //线程要执行的任务
        for (int i = 0; i < 5; i++) {
            System.out.println("线程1："+i);
        }
    }
}
