package com.luo.demo2threadApi;



public class ThreadApiDemo1 {
    public static void main(String[] args) {

        //目标：了解线程的常用方法
        //1.为了区分线程，线程名字
            Thread t1 = new MyThread1();
            t1.setName("线程一号");//线程名字的设置必须放在启动线程之前
            t1.start();
        System.out.println(t1.getName());//线程名字Thread-0;Thread-索引




        //还可以使用有参构造器为线程设置名字
        Thread t2 = new MyThread1("二号线程");
            t2.start();
        System.out.println(t2.getName());//线程名字Thread-1;Thread-索引



        //使用runnable接口创建线程是可以直接在包装时为线程设置名字
       // Thread t1 = new Thread(r1, "线程1");


        //主线程任务
        //哪个线程调用这个代码，就打印哪个线程的名字
       Thread m= Thread.currentThread();
       m.setName("主线程");
        System.out.println(m.getName());//线程名字main,主线程名称
        for (int i = 0; i < 4; i++) {
                System.out.println("主线程："+i);
            }
        }
    }

    class MyThread extends Thread{
    public MyThread() {
    }
        public MyThread(String a) {
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
