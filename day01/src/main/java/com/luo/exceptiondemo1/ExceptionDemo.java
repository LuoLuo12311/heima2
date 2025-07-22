package com.luo.exceptiondemo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        //目标：认识异常体系，了解异常的基本作用以及分类

        //show();
        try {//监视代码如果出现异常会被catch拦截
            show2();
        } catch (/*Parse*/Exception e) {
            System.out.println("格式不一致");

            throw new RuntimeException(e);//打印这个异常的信息

        }
    }

    //定义一个方法认识编译时异常，编译时不通过
    public static void show2() throws /*Parse*/Exception {//抛出异常,异常的基本处理之一，向外抛出异常

        System.out.println("程序开始============");
        String s = "2023-08-14 11:12:13";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM-dd HH:mm:ss");

        Date date= sdf.parse(s);//未做异常处理时爆红，典型的编译时异常
        // 提醒程序员这里的程序很容易出错，请你小心
        System.out.println(date);
        System.out.println("程序结束============");
    }

    //定义一个方法认识运行时异常
    public static void show(){
        //运行时异常的特点，编译阶段并不会报错，但是运行阶段出现的异常，继承自 RuntimeException
        int a = 10;
        int b = 0;
        int c = a / b;
        System.out.println(c);
    }
}
