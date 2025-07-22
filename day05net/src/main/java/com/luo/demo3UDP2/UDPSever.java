package com.luo.demo3UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSever {
    public static void main(String[] args) throws Exception {
        //目标：完成UDP通信，多发多收UDP服务端开发
        System.out.println("服务端启动了");
        //1.先创建一个接受段对象，并注册端口
        DatagramSocket ds = new DatagramSocket(10086);
        //2.创建一个数据包对象接收数据（接受者）
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        while (true) {
            //3.接收数据，封装到数据包对象中
            ds.receive(dp);//阻塞式接收数据
            //4.打印数据
            //如何实现接受多少数据打印多少
            //获取当前数据的长度
            int len = dp.getLength();
            System.out.println(new String(dp.getData(),0,dp.getLength()));

            String s= new String(buf, 0,len);//创建一个字符串对象，把数据包中的数据转换成字符串0到len个字节
            System.out.println("服务端收到了   "+s);
            //获取对方的IP对象
            System.out.println("消息由IP地址："+dp.getAddress().getHostAddress()+"端口："+ dp.getPort()+"  发送");

            //服务端不需要关闭管道
        }




    }
}
