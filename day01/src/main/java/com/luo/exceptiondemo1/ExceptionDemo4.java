package com.luo.exceptiondemo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo4 {
    public static void main(String[] args)  {
        //目标：掌握异常的处理方案一
        //底层异常都抛出给最外层调用者，最外层捕获异常，记录异常，相应合适信息给用户观看
        System.out.println("程序开始");
        try {
            show2();
            System.out.println("成功");
        } catch (Exception e) {
         e.printStackTrace();
         System.out.println("失败");

        }
        System.out.println("程序结束");

    }

    public static void show2() throws /*Parse*/Exception {//抛出异常,异常的基本处理之一，向外抛出异常

        System.out.println("程序开始============");
        String s = "2023-08-14 11:12:13";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM-dd HH:mm:ss");

        Date date= sdf.parse(s);//未做异常处理时爆红，典型的编译时异常
        // 提醒程序员这里的程序很容易出错，请你小心
        System.out.println(date);
        System.out.println("程序结束============");
    }
}
