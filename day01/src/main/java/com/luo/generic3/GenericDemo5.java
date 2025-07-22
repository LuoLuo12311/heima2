package com.luo.generic3;

import java.util.ArrayList;

public class GenericDemo5 {
    public static void main(String[] args) {
        //目标：理解通配符和上下限
        //通配符就是”？“可以在使用泛型的时候，使用通配符代替泛型类型
        //通配符的上下限：？ extends Car:表示该泛型只能接受Car或者Car的子类
        //                ? super Car:表示该泛型只能接受Car或者Car的父类
        ArrayList<? extends Car> list = new ArrayList<XiaoMi>();

    }
    //需求：开发一个极品飞车游戏
    //虽然xiaomi是Car的子类，但是ArrayList<xiaomi>和ArrayList<Car>是没有关系的
    //使用？通配符解决，在使用泛型时代表一切类型；E，T，K，V是在定义泛型时使用与？不同
    //通配符的上下限？ extends Car:表示该泛型只能接受Car或者Car的子类
    //? super Car:表示该泛型只能接受Car或者Car的父类
    public static void playGame(ArrayList<? extends Car> car){

    }
    public static< T> void playGame2(T []t) {

    }

}
