package com.luo.demo2map;

import java.util.HashMap;
import java.util.Map;

public class MapTraverseDemo5 {
    public static void main(String[] args) {
        //目标：掌握map集合的遍历方式之三：lambda表达式遍历
        //jdk8开始支持
        Map<String, String> map = new HashMap<>();
        map.put("001", "张三");
        map.put("002", "李四");
        map.put("003", "王五");
        map.put("004", "赵六");
        map.put("005", "孙七");
        System.out.println(map);




        //1.直接调用map集合的foreach 方法进行遍历
        map.forEach((k, v) -> System.out.println(k + "=" + v));

    }
}
