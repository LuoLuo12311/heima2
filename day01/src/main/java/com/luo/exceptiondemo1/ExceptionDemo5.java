package com.luo.exceptiondemo1;

import java.util.Scanner;

public class ExceptionDemo5 {
    public static void main(String[] args) {
        //目标：认识异常处理的第二种方案
        //最外层捕获异常后尝试重新修复（体现程序的健壮性）
        //接受用户的一个定价
        double price = 0;

        while (true) {
            System.out.println("程序开始==========");
            try {
                price = userPrice();//ctrl+alt+t包围try catch
                System.out.println("设置成功");
                break;//推出循环
            } catch (Exception e) {
              System.out.println("用户输入的格式有误");

            }

        }
        System.out.println("用户输入的定价是："+price);
        System.out.println("程序结束==========");

    }
    public static double userPrice() {
    //用户输入一个定价
        System.out.println("请输入一个商品：");
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        return price;
    }
}
