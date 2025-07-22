package com.luo.generic;

public class GenericDemo2 {
    public static void main(String[] args) {
        //目标：学会自定义泛型类
        //模拟arraylist集合定义自己的my arraylist

        MyArrayList<String> list = new MyArrayList<>();//jdk7之后后面的类型声明可以不写
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list.get(0));

    }

}
