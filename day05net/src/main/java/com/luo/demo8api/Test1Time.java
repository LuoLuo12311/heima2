package com.luo.demo8api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1Time {
    public static void main(String[] args) {
        //目标，掌握java中提供的获取时间的方案
        //jdk8之前的方案：Date获取此刻时间，老项目使用较多//线程不安全，一个时间整个项目的时间都被修改了不安全
       Date d = new Date();
       System.out.println(d);
       //对信息进行格式化SimpleDateFormat--简单日期格式化，格式化时间对象，成为我们喜欢的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EE a");//(yyyy年MM月dd日 HH:mm:ss)
        //，                                        sun公司规定yyyy-MM-dd HH:mm:ss EEE a：年月日时分秒 星期上午下午
        String format = sdf.format(d);
        System.out.println(format);



        //jdk8之后的方案：LocalDate，LocalTime，LocalDateTime获取此刻时间，新项目使用较多
        //LocalDate 取年月日
        //LocalTime 取时分秒
        //LocalDateTime 取年月日时分秒
        LocalDateTime now = LocalDateTime.now();//不让你创建对象，直接使用它的方法返回
        System.out.println(now);//甚至可以拿到纳秒
        //为什么新项目更加推荐这种方式，因为他获取数据更加方便
        System.out.println(now.getYear());//获取年
        System.out.println(now.getMonthValue());//获取月
        System.out.println(now.getDayOfMonth());//获取一月的第几天
        System.out.println(now.getDayOfYear());//获取一年中的第几天
        //格式化（使用DataTimeFormatter）//也是调用一个静态方法，返回一个DateTimeFormatter对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        String format1 = dtf.format(now);
        System.out.println( format1);


    }
}
