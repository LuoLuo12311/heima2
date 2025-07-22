package com.luo.demo5synchronizedMethod;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private double balance;



    public synchronized void drawMoney(double n){//在方法上加锁，synchronized关键字修饰就线程安全了
        if(balance >= n){
            System.out.println( Thread.currentThread().getName() + "取钱成功，取出来了：" + n);
            balance -= n;
            System.out.println(Thread.currentThread().getName() +"余额为：" + balance);

        }
        else{
            System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足！");
        }

    }



}
