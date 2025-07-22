package com.luo.demo7TCP4_BS;

import java.io.*;
import java.net.Socket;
import java.util.stream.Stream;

public class SeverReader extends  Thread {

    private Socket s;

    public SeverReader(Socket s) {


        this.s = s;
    }

    @Override
    public void run() {
        //读取管道的消息

        try {

            //给当前对应的浏览器管道响应一个网页数据回去
            OutputStream os=s.getOutputStream();
            //通过字节输出流包装写出数据，给客户端也就是浏览器
            //注意服务器必须给浏览器响应http协议规定的数据的的格式，否则浏览器不识别返回的数据

            //把字节输出流包装成打印流（因为打印流可以自动换行），不需要自己控制换行符更加方便
            PrintStream dos = new PrintStream(os);

            //开始写网页数据
            dos.println("HTTP/1.1 200 OK");//协议格式头不能改变很严谨的协议格式
            dos.println("Content-Type:text/html;charset=utf-8");//告诉浏览器返回的数据类型和编码格式//以文本或者网页的形式在浏览器显示

            dos.println();//空行，告诉浏览器结束头部信息，开始返回数据
            dos.println("<html>");
            dos.println("<head><title>服务器响应标题</title></head>");
            dos.println("<body>");
            dos.println("<h1 style='color:red;font-size=20px' >服务器响应内容</h1>");
            dos.println("</body>");
            dos.println("</html>");

            dos.close();
            s.close();//为什么与浏览器通信时服务端关闭流
            //因为浏览器通信一般是短链接，不需要长期通信
        } catch (Exception e) {
            //追踪下线逻辑//将异常信息显示更换为下线提示
            System.out.println("客户端下线"+s.getInetAddress().getHostAddress()+":"+s.getPort());
        }
    }
}
