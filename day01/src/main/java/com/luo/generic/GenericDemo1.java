package com.luo.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class GenericDemo1 {
    public static void main(String[] args) {

        //目标：认识泛型，搞清使用泛型的好处
        //没有使用泛型时，集合中可以存放任意类型的数据
       ArrayList list = new ArrayList< >();
       //尖括号中不做限制可以加入任意类型的变量
        list.add("hello");
        list.add(123);
        list.add(true);
        list .add('a');
        list.add(new Object());
        //获取数据
        for (int i = 0; i <list.size() ; i++) {
            Object obj = list.get(i);//类型不同只能赋给Object类型变量

            System.out.println(list.get(i));
        }
        //没有使用泛型时开发中可能会出现数据转换异常



        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        for (int i = 0; i <list2.size() ; i++) {
            String s = list2.get(i);
            int a = Integer.parseInt(s);

            System.out.println(a);
        }

    }
}
