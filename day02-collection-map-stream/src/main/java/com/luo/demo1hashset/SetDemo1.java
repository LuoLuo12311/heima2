package com.luo.demo1hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
        //目标：认识set家族集合的特点
        Set<String> s = new HashSet<>();//多态写法,经典代码
        s.add("hello");
        s.add("world");
        s.add("java");
        s.add("hello");
        System.out.println(s);//[hello, world, java]
        //1.hashset特点：无序，不重复，无索引
        //2.linked hashset，有序，不重复，无索引
        //为什么有序：底层原理：哈希表+链表，使用双链表记录添加顺序（每个节点更加浪费内存）
        //没有get系列方法
        Set<String> s1 = new LinkedHashSet<>();
        s1.add("hello");
        s1.add("world");
        s1.add("java");
        s1.add("hello");
        System.out.println(s1);

        //3.tree set，有排序（默认一定要大小升序排序），不重复，无索引
        //底层原理：红黑树进行的排序
        //对于数值类型Int，Integer，Long，Date，包装类，会自动进行排序按照数值本身大小进行排序
        //String对于字符串类型按照首字符的编号升序排序
        //对于自定义类型如Student，TreeSet默认是无法直接排序的
        //所以对于对象类型，会调用对象中的compareTo方法进行排序
        Set<String> s2 = new TreeSet<>();
        s2.add("hello");
        s2.add("world");
        s2.add("java");
        s2.add("hello");
        System.out.println(s2);

        System.out.println(s2.hashCode());

    }
}
