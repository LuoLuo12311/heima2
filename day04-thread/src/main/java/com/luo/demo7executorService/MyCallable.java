package com.luo.demo7executorService;

import java.util.concurrent.Callable;

//1.定义一个实现类，实现Callable接口
 public class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }//构造方法传参
    @Override//实现call 方法封装要做的 工作，和要返回的数据
    public String call() throws Exception {//call方法是一个泛型方法，返回值类型可以任意，但是必须和FutureTask类中泛型一致
        System.out.println( Thread.currentThread().getName()+"线程开始执行");
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += i;
        }
        return "计算出0到"+n+"的和"+sum+ "";
    }
}
