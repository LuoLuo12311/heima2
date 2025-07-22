package com.luo.exceptiondemo1;

public class ExceptionDemo2 {
    //异常的作用1，定位程序的关键bug信息
    public static void main(String[] args) {
        //目标：了解异常的作用
        System.out.println("程序开始");
        try {
            System.out.println(show(10,1));
            //System.out.println(show(10,0));
            System.out.println("底层方法执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("底层方法执行失败");
        }
        System.out.println("程序结束");
    }
    //异常的作用2可以作为方法内部的一种特殊返回值，以便通知上层调用者，方法的执行问题

    //需求：求两个数的除的结果，并返回这个结果
    public static int show(int a,int b) throws Exception {

        if (b == 0){
            //throw new RuntimeException("除数不能为0");
            //因为程序必须需要一个返回值，但是为了避免异常中断程序，且不返回，没有意义的-1或者其他数值
            //可以返回一个异常给上层，返回的异常还能告知上层底层执行成功还是失败
            //也可以抛出一个编译时异常，警示更加强烈，向上抛更加强烈
            throw new Exception("除数不能为0");
        }
        int c = a / b;
        return c;
    }
}
