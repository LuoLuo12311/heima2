package com.luo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Sever {

    //定义一个集合容器，存储所有登录进来的客户端管道，以便，将来群发消息给他们
    //--这个集合只需要一个记住所有的在线的客户端socket
    //这个集合应该定义一个map集合，建是存储客户端的管道，值是这个管道的用户名
    public static final Map<Socket,String> onlineClients=new HashMap<>();
    public static void main(String[] args)  {
        //服务端启动程序
        System.out.println("服务器启动成功");
        //1.注册端口
        try {
            ServerSocket  ss=new ServerSocket(Constant.PORT);//端口一般会被配置成常量，定义一个常量包出来配置
            //2.主线程接收客户端的链接请求
            while (true) {
                //3.调用 accept方法阻塞等待客户端链接，一旦有客户链接，会返回一个socket对象。
                System.out.println("等待客户端连接...");

                Socket s = ss.accept();
                //创建一个线程处理这个客户端的请求
                //把这个管道交给一个独立的线程来处理，以便支持很多客户端可以同时进来通信
                new SeverReaderThread(s).start();

                System.out.println("一个客户端上线了"+s.getInetAddress().getHostAddress()+":"+s.getPort());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
