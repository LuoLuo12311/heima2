package com.luo.demo4synchronizedCode;



public class ThreadSafeDemo1 {
    public static void main(String[] args) {
        //目标：解决线程安全问题：线程同步
        //线程同步的方式一：同步代码块
        // ctrl+alt+t, synchronized ("luo")锁住关键代码括号中填一个唯一对象作为锁对象
        // 随便选择唯一对象做锁对象的性能差，会影响其它无关线程的执行
        //锁对象的使用规范：
        //建议将共享资源作为锁对象，
        // 对于实列方法建议使用this作为锁对象
        // 对于静态方法建议使用字节码（类名.class）作为锁对象
        //1.设计一个账户类，用于创造小明小红共同的账户对象，存入10万元

        Account account = new Account("1001", 100000);

        //设计线程类
        //2.创建小明小红两个线程，模拟小明小红同时去同一个账户取款十万

        new DrawMoneyThread("小明",account).start();
        new DrawMoneyThread("小红",account).start();




    }
}
