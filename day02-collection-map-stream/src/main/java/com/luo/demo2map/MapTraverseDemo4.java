package com.luo.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo4 {
    public static void main(String[] args) {
        //目标：掌握map集合的遍历方式之二：键值对
        Map<String, String> map = new HashMap<>();
        map.put("001", "张三");
        map.put("002", "李四");
        map.put("003", "王五");
        map.put("004", "赵六");
        map.put("005", "孙七");
        System.out.println(map);

        //把map集合转换成set集合，里面的元素类型都是键值对（Map.Entry<String,String>）
        Set<Map.Entry<String, String>> entries = map.entrySet();//var快捷键：
        for (Map.Entry<String, String> entry : entries) {
            //遍历set集合得到每一个键值对类型元素
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "=" + value);

        }
    }
}
