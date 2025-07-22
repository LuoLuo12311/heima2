package com.luo.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapTest {
    public static void main(String[] args) {
        // 目标：实现map的一个综合案例1
        // 需求：某个班级80名学生，现在要组织秋游活动，班长提供了四个景点分别是A，B，C，D
        // 每个学生只能选择一个景点，请统计出最终那个景点想去的人最多
        // 将80个学生选择的景点数据拿到程序中去

        // 创建一个 HashMap 实例来存储景点和对应的选中次数
        Map<String, Integer> destinationCounts = new HashMap<>();

        // 初始化景点选项
        String[] destinations = {"A", "B", "C", "D"};

        // 使用 Random 来模拟学生的选择
        Random random = new Random();

        // 模拟80个学生选择景点
        for (int i = 0; i < 80; i++) {
            // 随机选择一个景点
            String selectedDestination = destinations[random.nextInt(destinations.length)];
            // 更新景点选择计数
            destinationCounts.put(selectedDestination, destinationCounts.getOrDefault(selectedDestination, 0) + 1);
        }

        // 输出每个景点的选中次数
        System.out.println("景点选择统计结果：" + destinationCounts);

        // 找出选中次数最多的景点
        String mostPopularDestination = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : destinationCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopularDestination = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        // 输出最受欢迎的景点
        System.out.println("最受欢迎的景点是：" + mostPopularDestination + "，共有 " + maxCount + " 人选中。");
    }
}
