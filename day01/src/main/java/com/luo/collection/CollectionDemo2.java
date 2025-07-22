package com.luo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //目标：搞清collection集合提供的通用集合功能

        Collection<String> c = new ArrayList<>();
        //添加元素
        c.add("hello");
        c.add("world");
        c.add("java");
        //获取元素个数
        System.out.println(c.size());
        //删除元素
        c.remove("hello");
        System.out.println(c.size());
        //判断集合是否为空
        System.out.println(c.isEmpty());
        //清空集合
        c.clear();
        System.out.println(c.isEmpty());
        //判断集合中是否包含某个元素
        System.out.println(c.contains("world"));
        //把集合转换成数组
        Object[] arr = c.toArray();
        System.out.println(Arrays.toString(arr));
        //把集合转换成字符串数组
        String[] arr2 = c.toArray(new String[0]);
        //或者
        String[] arr3 = c.toArray(String[]::new);

    }
}
