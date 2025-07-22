package com.luo.exceptiondemo1;

//编译时异常对别人的提醒非常强烈适合严重问题需要着重注意//尽可能不用容易干扰
//运行时异常使用的更多
public class ExceptionDemo3 {
    public static void main(String[] args) {
        //目标：认识自定义异常
        //自定义编译时异常
        System.out.println("程序开始");
        try {
            show(1212);
            System.out.println("底层方法执行成功");
        } catch (AgeException e) {

            e.printStackTrace();
            System.out.println("执行失败");
        }

        System.out.println("程序结束");

    }
    //需求如果我们收到了年龄小于1岁大于200岁就是一个年龄非法异常
    public static void show(int age) throws AgeException{
        //年龄非法抛出异常
        if (age < 1 || age > 200){
            throw new AgeException("年龄非法");
        }
        else System.out.println("年龄合法"+ age);
    }
}
