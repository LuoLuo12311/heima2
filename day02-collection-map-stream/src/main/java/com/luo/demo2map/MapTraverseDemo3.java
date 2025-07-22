package com.luo.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo3 {
    public static void main(String[] args) {
        //目标：掌握map集合的遍历方式之一：键找值
        Map<String, String> map = new HashMap<>();
        map.put("001", "张三");
        map.put("002", "李四");
        map.put("003", "王五");
        map.put("004", "赵六");
        map.put("005", "孙七");
        System.out.println(map);
        //先提取map集合的全部键到一个set集合中去
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        //遍历set集合，获取每一个键
        for (String key : keySet) {
            //根据键去找值
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
