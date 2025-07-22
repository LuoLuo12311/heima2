package com.luo.demo1hashset;

import java.util.HashSet;
import java.util.Set;

public class SetDemo3 {
    public static void main(String[] args) {

        //目标：掌握hashset集合的去重操作

        Student s4 = new Student("小名", 28, 100);
        Student s3 = new Student("小里", 18, 100);
        Student s2 = new Student("小王", 18, 100);
        Student s1 = new Student("小王", 18, 100);
        Set<Student> s = new HashSet<>();
        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);
        System.out.println(s);
        //不能自动去重的原因是：四个对象的hash值并不相同
        //如果希望内容相同的不同对象就被认为是重复了，
        // 那么必须重写hashCode和equals方法
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));


    }
}
