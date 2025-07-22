package com.luo.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        //目标：掌握list系列集合的独有功能
        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("hello");
        System.out.println(list);
        //给第三个位置插入一个数据

        list.add(2,"javaSE");
        System.out.println(list);
        list.remove(2);//根据下标删除，返回删除的数据
        System.out.println(list);
        //修改数据
        list.set(2,"javaEE");//根据下标修改数据，返回修改的 数据
        //根据索引获取数据

        System.out.println(list.get(2));
        
        
        //有索引可以使用for循环遍历数据
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }

        //迭代器遍历

    }
}
