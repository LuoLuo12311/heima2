package com.luo.demo4synchronizedCode;



public class DrawMoneyThread extends Thread {
    //线程类中创建账户对象存储传入的账户对象
    private Account account;





    public DrawMoneyThread(String name, Account account) {


        super(name);//使用super关键字调用父类的构造方法的时候必须要在第一行
        this.account = account;
    }

    @Override
    public void run() {
        //取钱业务
        account.drawMoney(100000);
    }
}
