package com.luo.demo4TCP;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下一发一收，客户端开发
        //1.创建一个Socket对象，请求与服务端的Socket对象建立连接，可靠连接
        Socket s = new Socket("127.0.0.1", 9999);//找自己的机器
        //2.从Socket对象中获取一个字节输出流对象，发送数据给服务端
        OutputStream os = s.getOutputStream();
        //3.将低级的字节输出流包装成高级的PrintWriter打印流，或者缓冲字节输出流，但是服务端的流也要一一对应
        //这里使用一个特殊输入流DataOutputStream//可以发送各种类型的数据，而且发啥就是啥
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
       dos.writeUTF("你好，这里是客户端");

        //4.释放资源
        s.close();

    }
}
