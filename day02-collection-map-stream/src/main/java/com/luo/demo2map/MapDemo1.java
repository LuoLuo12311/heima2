package com.luo.demo2map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//如果你要存一一对应的数据可以考虑使用map集合
public class MapDemo1 {
    public static void main(String[] args) {

        //目标认识map集合的体系特点
        //1.创建map集合
        //无序，建不重复，没有索引，键值对都可以是null，对值没有要求，可以重复
        //Treemap 按照建可排序不重复，无索引
        Map<String,Integer> map = new HashMap<>();//又是一行经典代码
        map.put("张三",18);
        map.put("李四",19);
        map.put("张三",20);
        map.put("王五",20);
        map.put(null,null);
        System.out.println(map);

        //2.创建linkedHashMap集合
        //有序，键值对可以重复，有索引，键值对都可以是null，对值没有要求，可以重复
        Map<String,Integer> map2 = new LinkedHashMap<>();
        map2.put("张三",18);
        map2.put("李四",19);
        map2.put("张三",20);
        map2.put("王五",20);
        map2.put(null,null);
        System.out.println(map2);
    }
}
