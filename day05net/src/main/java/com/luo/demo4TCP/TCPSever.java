package com.luo.demo4TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSever {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下一发一收，服务端开发
        //注意：这里服务端将不再创建Socket对象，而是使用一个ServerSocket对象，来监听客户端的请求
        //1.创建一个ServerSocket对象，指定端口号
        ServerSocket ss = new ServerSocket(9999);//注册端口
        //2.调用accept接收方法阻塞等待客户端链接，一旦有客户短链接，会返回一个socket对象。
        Socket s = ss.accept();
        System.out.println("服务端启动成功");
        //3.使用socket对象获取输入流，读取从服务端发送过来的数据，
        InputStream is = s.getInputStream();
        //4.把字节输入流包装成与服务端对应的特殊数据输入流
        DataInputStream dis = new DataInputStream(is);
        //5.读取数据
        int i = dis.readInt();
         String s1 = dis.readUTF();
        System.out.println("收到客户端消息id:"+ i+ "  信息:"+s1);
        //知道客户端的IP与端口
        System.out.println("客户端的IP:"+s.getInetAddress().getHostAddress());
        System.out.println("客户端的端口:"+s.getPort());


    }
}
