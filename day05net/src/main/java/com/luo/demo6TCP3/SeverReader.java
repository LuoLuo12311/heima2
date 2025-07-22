package com.luo.demo6TCP3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SeverReader extends  Thread {

    private Socket s;

    public SeverReader(Socket s) {


        this.s = s;
    }

    @Override
    public void run() {
        //读取管道的消息

        try {
            //3.使用socket对象获取输入流，读取从服务端发送过来的数据，
            InputStream is = s.getInputStream();
            //4.把字节输入流包装成与服务端对应的特殊数据输入流
            DataInputStream dis = new DataInputStream(is);
            while (true) {//服务端一般不需要关闭管道
                //5.读取数据
                //int i = dis.readInt();//等待客服端发送数据
                String s1 = dis.readUTF();
                System.out.println("收到客户端 信息:" + s1);
                //知道客户端的IP与端口
                System.out.println("客户端的IP:" + s.getInetAddress().getHostAddress());
                System.out.println("客户端的端口:" + s.getPort());
                System.out.println("=======================================");
            }

        } catch (Exception e) {
            //追踪下线逻辑//将异常信息显示更换为下线提示
            System.out.println("客户端下线"+s.getInetAddress().getHostAddress()+":"+s.getPort());
        }
    }
}
