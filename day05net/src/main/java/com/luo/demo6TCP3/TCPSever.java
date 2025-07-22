package com.luo.demo6TCP3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSever {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下多发多收，服务端开发，支持多个客户端连接开发

        System.out.println("服务端启动成功");
        //使用一个死循环，让主线程不断负责接受客户端链接，然后将链接创建好的管道，交给一个个子线程来完成
        //这样就实现了多个客户端连接


        //1.创建一个ServerSocket对象，指定端口号

        ServerSocket ss = new ServerSocket(9999);//注册端口

        //死循环，让主线程不断接受客户端连接接受管道
        while (true) {
            //2.调用accept接收方法阻塞等待客户端链接，一旦有客户短链接，会返回一个socket对象。
            Socket s = ss.accept();
            System.out.println(//追踪上线逻辑
                    "一个客户端上线了"+s.getInetAddress().getHostAddress()+":"+s.getPort()
            );

            //3.主线程每接到一个管道，都把其交给一个独立的子线程来处理这个客户端的

            new SeverReader(s).start();

        }


    }
}
