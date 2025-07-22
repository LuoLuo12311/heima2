package com.luo.demo6TCP3;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下多发多收，客户端开发
        //1.创建一个Socket对象，请求与服务端的Socket对象建立连接，可靠连接
        Socket s = new Socket("127.0.0.1", 9999);//找自己的机器
        //2.从Socket对象中获取一个字节输出流对象，发送数据给服务端
        OutputStream os = s.getOutputStream();
        //3.将低级的字节输出流包装成高级的PrintWriter打印流，或者缓冲字节输出流，但是服务端的流也要一一对应
        //这里使用一个特殊输入流DataOutputStream//可以发送各种类型的数据，而且发啥就是啥
        DataOutputStream dos = new DataOutputStream(os);
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("请输入要发送的数据：");
            String line = scanner.next();

            if ("exit".equals(line)) {
                System.out.println("客户端退出成功");
                dos.close();//输出管道
                s.close();//通信管道，一般就关通信管道就够了
                break;
            }

           /* int a=1 ;
            dos.writeInt(a);
            a++;*/
            dos.writeUTF(line);
            dos.flush();//刷新数据，因为没有关闭管道，所以数据不会写入到目的地，所以这时需要刷新管道来确保数据写入目的地
        }



    }
}
