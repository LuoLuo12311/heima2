package com.luo.demo8api;

import java.math.BigDecimal;

public class Test3BigDecimal {
    public static void main(String[] args) {
        //目标：BigDecimal解决小数运算结果失真问题
        //用来解决浮点数精度丢失，结果失真的问题
        double a = 0.1;
        double b = 0.2;

        System.out.println(a+b);//0.30000000000000004结果失真
        //解决方法：使用BigDecimal
        //1.把小数包装成BigDecimal对象来运算才可以
        //不要调double的构造方法，调String的构造方法，因为double的构造方法还是会丢失精度
        //必须使用字符串构造器才能解决失真问题
        /*BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.2");
        System.out.println(b1.add(b2));*/
        //优化方案可以直接调用他的valueOF方法，底层调用的也是字符串构造器
        BigDecimal b1 = BigDecimal.valueOf(0.1);
        BigDecimal b2 = BigDecimal.valueOf(0.3);
        BigDecimal add = b1.add(b2);
        double v = add.doubleValue();//目的：转换成double类型，
        System.out.println(  v);//add方法

        //除法演示
        BigDecimal b3 = BigDecimal.valueOf(0.1);
        BigDecimal b4 = BigDecimal.valueOf(0.3);//除不尽就会抛出异常
       // BigDecimal divide = b3.divide(b4);
        //解决除不尽的方案
        //调用它的一个重载方法
        BigDecimal divide1 = b3.divide(b4, 10, BigDecimal.ROUND_HALF_UP);
        // public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
        // scale：指定精度   roundingMode：指定舍入模式
        //ROUND_HALF_UP:四舍五入
        double v2 = divide1.doubleValue();
        //double v1 = divide.doubleValue();
        //System.out.println(v1);
        System.out.println(v2);
    }
}
