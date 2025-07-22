package com.luo.demo1threadCreate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreateDemo3 {
    public static void main(String[] args) {

        //目标：创建线程方式三，实现Callable接口来创建
        //前两种创建线程的方式都存在一个问题：假如线程执行完毕后有一些数据需要返回，它们重写的run方法均无法直接返回结果
        //重写地run方法都是void类型
        //第三种方式：实现Callable接口，FutureTask类来实现最大的优点就是：可以返回线程执行完毕后的结果


        //创建任务对象，定义一个类实现Callable接口，重写call方法，封装要做的 工作，和要返回的数据
        //把Callable接口实现类，包装成FutureTask类(线程任务对象)，然后再传给Thread类对象，启动线程

        //2.创建Callable接口实现类对象
        Callable<String> c1 = new MyCallable(100);
        //3.把Callable接口实现类对象，包装成FutureTask类（线程任务类）对象

/**
 * 未来任务对象FutureTask的作用：
 * 1，本质是一个线程任务对象，可以交给我们的thread线程对象处理
 * 2，可以获取线程执行完毕后的结果
 */
        FutureTask<String> ft1 = new FutureTask<>(c1);//   public FutureTask(Callable<V> callable)

        //4.创建Thread类对象，把未来任务对象FutureTask作为构造参数传递给Thread类对象，创建线程对象
        Thread t1 = new Thread(ft1);
        //5.启动线程
        t1.start();


        //第二个线程
        Callable<String> c2 = new MyCallable(67);
        FutureTask<String> ft2 = new FutureTask<>(c2);
        Thread t2 = new Thread(ft2);
        t2.start();



        //获取线程执行完毕后的结果（主线程）

        try {
            System.out.println(ft1.get());//如果发现第一个线程还没有执行完毕，会让出CPU，等待第一个线程执行完毕，再获取结果
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(ft2.get());//推荐分开try catch
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
//1.定义一个实现类，实现Callable接口
class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }//构造方法传参
    @Override//实现call 方法封装要做的 工作，和要返回的数据
    public String call() throws Exception {//call方法是一个泛型方法，返回值类型可以任意，但是必须和FutureTask类中泛型一致
        System.out.println("线程开始执行");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("线程任务代码" + i);
            sum += i;
        }
        return "计算出0到"+n+"的和"+sum+ "";
    }
}
