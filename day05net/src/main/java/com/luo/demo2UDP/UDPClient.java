package com.luo.demo2UDP;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //目标：UDP客户端完成UDP通信，一发一收
        //1.创建发送端对象（发消息的人）
        System.out.println("客户端启动了");
        DatagramSocket ds = new DatagramSocket();//发送端端口，动态端口，程序默认随机分配一个端口

        //2.创建数据包对象，封装要发送的数据（韭菜盘子）
        byte[] bys = "hello,UDP".getBytes();
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
        //4.关闭发送端对象(释放资源)
        ds.close();
    }
}
