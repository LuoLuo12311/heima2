package com.luo.demo8test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class ThreadTest {
    // 共享红包队列
    private static final ConcurrentLinkedQueue<Double> redPackets = new ConcurrentLinkedQueue<>();
    // 员工红包总额统计
    private static final AtomicIntegerArray employeeAmounts = new AtomicIntegerArray(100);
    // 用于等待所有红包被抢完
    private static final CountDownLatch latch = new CountDownLatch(200);

    public static void main(String[] args) {
        // 初始化红包
        initRedPackets();
        
        // 创建并启动100个员工线程
        for (int i = 1; i <= 100; i++) {
            new EmployeeThread(i).start();
        }
        
        // 等待所有红包被抢完
        try {
            latch.await();
            System.out.println("活动结束！");
            // 显示员工红包总额排名
            displayRankings();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 初始化红包
    public static void initRedPackets() {
        // 生成160个小红包（1-30元）
        for (int i = 0; i < 160; i++) {
            double amount = Math.floor(Math.random() * 30 + 1) * 100 / 100;
            redPackets.add(amount);
        }
        // 生成40个大红包（31-100元）
        for (int i = 0; i < 40; i++) {
            double amount = Math.floor(Math.random() * 70 + 31) * 100 / 100;
            redPackets.add(amount);
        }
    }

    // 员工线程类
    static class EmployeeThread extends Thread {
        private final int employeeId;

        public EmployeeThread(int employeeId) {
            this.employeeId = employeeId;
        }

        @Override
        public void run() {
            while (true) {
                Double amount = redPackets.poll();
                if (amount == null) {
                    break;
                }
                // 更新员工红包总额
                employeeAmounts.addAndGet(employeeId - 1, (int) (amount * 100)); // 以分为单位避免浮点误差
                System.out.println(employeeId + "号员工抢到红包：" + amount + "元");
                latch.countDown();
            }
        }
    }

    // 显示员工红包总额排名
    private static void displayRankings() {
        // 创建员工金额数组
        double[][] rankings = new double[100][2];
        for (int i = 0; i < 100; i++) {
            rankings[i][0] = i + 1; // 员工ID
            rankings[i][1] = employeeAmounts.get(i) / 100.0; // 转换为元
        }
        
        // 冒泡排序（降序）
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 99 - i; j++) {
                if (rankings[j][1] < rankings[j + 1][1]) {
                    // 交换位置
                    double[] temp = rankings[j];
                    rankings[j] = rankings[j + 1];
                    rankings[j + 1] = temp;
                }
            }
        }
        
        // 输出排名
        System.out.println("\n员工红包总额排名：");
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d号员工抢红包总计：%.2f元\n", (int) rankings[i][0], rankings[i][1]);
        }
    }
}
