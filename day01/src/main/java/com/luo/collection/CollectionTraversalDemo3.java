package com.luo.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTraversalDemo3 {
    public static void main(String[] args) {
        //目标：集合掌握collection的遍历方式之三，lambda表达式遍历
        //jdk8开始支持

        Collection<String> c = new ArrayList<>();

        c.add("hello");
        c.add("world");
        c.add("java");
        //由一个函数式接口的匿名内部类简化而来
        c.forEach(s -> System.out.println(s));
        //进一步简化，由方法引用简化
        c.forEach(System.out::println);

    }
}
