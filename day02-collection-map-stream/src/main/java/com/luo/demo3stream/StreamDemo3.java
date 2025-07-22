package com.luo.demo3stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        //目标：掌握stream提供的常用的中间方法，对流上的数据进行处理（返回新流，支持链式编程）

        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("hello");
        //.var//快捷建，给一个对应变量接受当前值
        //1.过滤方法.filter(s -> s.length() <=9)
         list.stream().filter(s -> s.length() <=9).filter(s -> s.startsWith("h")).forEach(System.out::println);

         //2.排序方法.sorted()//因为Double本身有值特性可以直接排
        List<Double> list2=new ArrayList<>();
        list2.add(4.5);
        list2.add(2.5);
        list2.add(1.5);
        list2.add(3.5);
        list2.add(5.5);
        list2.stream().sorted().forEach(System.out::println);//默认升序//想要降序，需要自己实现Comparator接口
        System.out.println("=======================");

        list2.stream().sorted(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        }).forEach(System.out::println);
        System.out.println("=======================");
        //简化后
        list2.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
        //如果希望自定义对象可以去重复，那么需要自己重写对象的hashcode和equals方法
        //加工，映射方法：把流上原来的数据都拿出来变成新数据再放到流上去
        list2.stream().map(s->"加十分后"+(s+10)).forEach(System.out::println);
        System.out.println("=======================");
        //合并流
        Stream<String> stream1 = list.stream();

        Stream<Double> stream2 = list2.stream();
        Stream<Object> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);
    }
}
