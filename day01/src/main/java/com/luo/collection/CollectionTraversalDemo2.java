package com.luo.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTraversalDemo2 {
    public static void main(String[] args) {
        //目标：集合掌握collection的遍历方式之二，增强for循环遍历，本质还是迭代遍历，但增强for循环既可以迭代数组也可以迭代集合
        String[] arr = {"hello","world","java"};
        for(String s : arr){
            System.out.println(s);
        }
        //增强for循环格式
//        for(数据类型 变量名 : 集合名){}

        Collection<String> c = new ArrayList<>();
        c.add("hello");
        c.add("world");
        c.add("java");
        for(String s : c){
            System.out.println(s);
        }
    }
}
