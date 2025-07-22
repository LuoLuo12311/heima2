package com.luo.demo3UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //目标：客户端完成UDP通信，多发多收
        //1.创建发送端对象（发消息的人）
        System.out.println("客户端启动了");
        DatagramSocket ds = new DatagramSocket();//发送端端口，动态端口，程序默认随机分配一个端口

        //输入扫描（放在循环外防止浪费内存）
        Scanner sc = new Scanner(System.in);
        while (true) {

            //提示用户输入
            System.out.println("请说你最喜欢的动物：");
            String msg = sc.nextLine();//nextLine()可以输入一行数据，包括空格

            //如果用户输入的是bye，则结束发送
            if ("bye".equals(msg)) {
                System.out.println("程序退出");
                ds.close();//关闭资源释放资源
                //其实应该放在finally里面，这里为了方便，放在这里
                break;}

            //2.创建数据包对象，封装要发送的数据（韭菜盘子）
            byte[] bys = msg.getBytes();
            /**
             *
             *  public DatagramPacket(byte[] buf, int length,
             *                           InetAddress address, int port)
             * 参数一：发送的数据
             * 参数二：发送数据的长度
             * 参数三：指定发送的目标地址
             * 参数四：指定发送的目标端口
             */
            DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getLocalHost(), 10086);


            //3.让发送端对象发送数据报的数据
            ds.send(dp);
        }
    }
}
