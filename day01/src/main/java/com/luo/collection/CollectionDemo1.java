package com.luo.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //目标：搞清单列集合的整体特点
        //list家族的特点：
        //有序、可重复，有索引
       List<String> list = new ArrayList<>();//前面是list父类 ，后面是ArrayList子类，体现了多态的思想
        list.add("hello");
        list.add("world");
        list.add("java");//有序：添加的顺序和获取的顺序一致，先加的在前后加的在后
        list.add("hello");//允许重复
        System.out.println(list);
        System.out.println(list.get(0));

        //Set家族集合特点
        //无序，不重复，无索引
        Set<String> set = new HashSet<>();
        set.add("hello");//不能重复，添加的顺序和获取的顺序不一致
        set.add("world");
        set.add("java");
        set.add("hello");


        System.out.println(set);
    }
}
