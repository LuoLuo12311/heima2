package com.luo.demo2threadApi;

public class ThreadApiDemo2 {
    public static void main(String[] args) {
        //目标：了解线程常用的使用方法二：sleep （线程休眠）方法
        for (int i = 0; i <12 ; i++) {

            System.out.println("线程1："+i);
            if(i==5){
                try {//会让当前执行的线程进入休眠状态，时间到了才会继续执行
                    Thread.sleep(5000);//线程休眠5秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
