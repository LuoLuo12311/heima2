package com.luo.demo6lock;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private double balance;
    private final Lock lc =new ReentrantLock();//创建锁对象//加个final保护锁对象



    public void drawMoney(double n){
        lc.lock();//加锁上锁
        try {
            if(balance >= n){
                System.out.println( Thread.currentThread().getName() + "取钱成功，取出来了：" + n);
                balance -= n;
                System.out.println(Thread.currentThread().getName() +"余额为：" + balance);
               // lc.unlock();//钱取完了解锁//不建议放在这里，因为如果之前的代码一出异常，就一直无法解锁
                //推荐在finally中解锁

            }
            else{
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足！");
            }
        } finally {
             lc.unlock();//在此处解锁
        }

    }



}
