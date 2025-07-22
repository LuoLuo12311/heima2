package com.luo.demo3stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo4 {
    public static void main(String[] args) {
        //目标：了解Stream流中常用的终结方法，统计收集操作
        List<Teacher> list = new ArrayList<>();




        list.add(new Teacher("张三", 18, 90));
        list.add(new Teacher("李四", 19, 80));
        list.add(new Teacher("王五", 20, 70));
        list.add(new Teacher("小张", 19, 80));
        System.out.println(list);


        list.stream().filter(t -> t.getAge() > 18).forEach(System.out::println);//遍历
        long count = list.stream().filter(t -> t.getAge() > 20).count();//统计

        System.out.println(count);

        Optional<String> max = list.stream().filter(t -> t.getAge() > 18).map(t -> t.getName()).max((t1, t2) -> t1.compareTo(t2));

        //流只能收集一次
        System.out.println(max.get());//Optional对象可以放空
        //stream流的收集操作//收集到集合和数组中
        List<String> list1 = list.stream().filter(t -> t.getAge() > 18)
                .map(t -> t.getName()).collect(Collectors.toList());//收集到list集合中
        System.out.println(list1);
        //收集到set集合中


        //收集到map集合中//                                                        建的声明          值的声明
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getAge));
        System.out.println(collect);


    }
}
