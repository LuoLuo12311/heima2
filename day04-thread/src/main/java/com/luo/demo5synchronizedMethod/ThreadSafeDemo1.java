package com.luo.demo5synchronizedMethod;

public class ThreadSafeDemo1 {
    public static void main(String[] args) {
        //目标：解决线程安全问题：线程同步
        //线程同步的方式二：同步方法

        //同步代码块，范围小性能好
        //同步方法，代码简单，可读性好
        //在核心方法之前上锁：加上synchronized关键字就行了
        //1.设计一个账户类，用于创造小明小红共同的账户对象，存入10万元

        Account account = new Account("1001", 100000);

        //设计线程类
        //2.创建小明小红两个线程，模拟小明小红同时去同一个账户取款十万

        new DrawMoneyThread("小明",account).start();
        new DrawMoneyThread("小红",account).start();




    }
}
