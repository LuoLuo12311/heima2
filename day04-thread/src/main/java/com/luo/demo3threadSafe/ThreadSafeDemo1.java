package com.luo.demo3threadSafe;

public class ThreadSafeDemo1 {
    public static void main(String[] args) {
        //目标：模拟线程安全问题
        //1.设计一个账户类，用于创造小明小红共同的账户对象，存入10万元

        Account account = new Account("1001", 100000);

        //设计线程类
        //2.创建小明小红两个线程，模拟小明小红同时去同一个账户取款十万

        new DrawMoneyThread("小明",account).start();
        new DrawMoneyThread("小红",account).start();




    }
}
