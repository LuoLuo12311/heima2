package com.luo.generic4;

import java.util.ArrayList;

public class GenericDemo6 {
    public static void main(String[] args) {
        //目标：理解泛型支持的类型：泛型与集合都不支持基本类型
        //ArrayList<int> list = new ArrayList<>();报错不支持
        //原因：泛型擦除：泛型工作在编译阶段编译后泛型就没用了会被擦除，所有类型会恢复成Object，所以不能使用基本类型

        //为了解决泛型不能使用基本类型的问题，可以使用包装类
        //1.手工包装
        //Integer i = new Integer(10);//jdk9开始就已经淘汰

        Integer j =  Integer.valueOf(10);//节省内存-127到128之间的数据已经提前为你缓存了//地址相同

        //2.自动包装，基本数据类型的数据可以直接变成包装对象类型的数据，不需要额外操作
        Integer i =  10;
        Integer k = 10989;
        System.out.println(i== j);
        System.out.println(k== j);
        //3.自动拆箱，包装对象类型数据可以直接变成基本数据类型数据，不需要额外操作
        int m = i;
        System.out.println(m);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);//自动装箱，把我们传入的整形值直接自动包装成Integer对象再给到ArrayList集合
        int n = list.get(0);//自动拆箱，把ArrayList集合中的Integer对象自动拆箱成int基本数据类型
        System.out.println("===========================================================");
        //包装类新增的其他功能
        //1，包装类可以把基本类型数据转换成字符串类型数据
        int a = 10;
        String s1 = Integer.toString(a);//”10“

        Integer a2=10;
        String s2 = a2.toString();
        String s = a + "luo";
        System.out.println(s);
        System.out.println(s1);
        System.out.println("==============================================================");
        //2，包装类可以把字符串转换成对应的基本数据类型，（很有用）
        String s3 = "10";
        System.out.println(s3+20);
        int a3 = Integer.parseInt(s3);
        System.out.println(a3+20);
        System.out.println(a3);
        //或者直接调用静态方法valueOf

        int a4 = Integer.valueOf(s3);
        System.out.println(a4+80);


    }
}
