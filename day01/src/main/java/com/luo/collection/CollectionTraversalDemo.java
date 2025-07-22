package com.luo.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//集合的遍历方式：
//1.使用迭代器
//2.使用foreach
//3.使用普通for循环
//4.使用lambda表达式
//5.使用stream流
public class CollectionTraversalDemo {
    public static void main(String[] args) {
        //目标：集合掌握collection的遍历方式之一，迭代遍历
        Collection<String> c = new ArrayList<>();
        c.add("hello");
        c.add("world");
        c.add("java");
        System.out.println(c);
        //1.得到集合的迭代器对象
        Iterator<String> it = c.iterator();

        //使用while循环遍历

        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);

        }



    }
}
