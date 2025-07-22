package com.luo.demo2map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {
    public static void main(String[] args) {
        // 创建一个 HashMap 实例
        Map<String, String> map = new HashMap<>();

        // 使用 put 方法添加键值对
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println("put操作后的Map：" + map);

        // 使用 get 方法获取指定键的值
        String value = map.get("key1");
        System.out.println("get(key1) 返回的值：" + value);

        // 使用 containsKey 检查是否包含指定键
        boolean hasKey = map.containsKey("key1");
        System.out.println("containsKey(key1): " + hasKey);

        // 使用 containsValue 检查是否包含指定值
        boolean hasValue = map.containsValue("value2");
        System.out.println("containsValue(value2): " + hasValue);

        // 使用 keySet 获取所有键的集合
        System.out.println("keySet(): " + map.keySet());

        // 使用 entrySet 获取所有键值对的集合
        System.out.println("entrySet(): " + map.entrySet());

        // 使用 remove 方法移除指定键及其对应的值
        map.remove("key1");
        System.out.println("remove(key1) 后的Map：" + map);
    }
}
