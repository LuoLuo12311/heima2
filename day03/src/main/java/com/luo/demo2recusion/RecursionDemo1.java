package com.luo.demo2recusion;

public class RecursionDemo1 {
    public static void main(String[] args) {
        //了解递归，认识递归的形式
        print(1);//直接递归，自己调用自己
        System.out.println("5的阶乘是："+factorial(5));
        System.out.println("1到5的和是："+addAll(5));
    }
    public static void print(int n){//方法在栈里跑，无限递归会挤爆栈的内存，造成栈溢出
        if(n>10){
            System.out.println("结束");
            return;
        }
        System.out.println("递归中");
        System.out.println(n);
        print(n+1);
    }
    //计算n的阶乘
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    //递归算法的三要素：递归的公式，递归的终结带点，递归的方向必须走向终结点
    //求1到n的和
    public static  int addAll(int n){
        if(n==1){
            return 1;
        }
        return n+addAll(n-1);
    }
}
