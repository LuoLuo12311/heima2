package com.luo.demo4fileoutputstream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //目标：学会使用FileOutputStream的使用，文件字节输出流
        //1.创建FileOutputStream对象文件字节输出流管道与文件接通，把文件名传递给构造方法，
        // 创建文件字节输出流管道，与目标文件接通
      //这是覆盖管道，会覆盖原来文件的内容 // OutputStream fos = new FileOutputStream("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo3fileinputstream\\read.txt");
        OutputStream fos = new FileOutputStream("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo3fileinputstream\\read.txt", true);

        //2.使用FileOutputStream对象中的方法write，把数据写入到文件中
        fos.write(97);
        fos.write(98);
        //fos.write('徐');//乱码，因为徐是三个字节
        fos.write('x');
        //3.写一个字节数组，一次写入多个字节
        byte[] bytes = {97,98,99,100,101};
        byte[] bytes1 = "中国".getBytes();//字符串转为字节数组，编码成字节数组
        fos.write(bytes);


        fos.write("\r\n".getBytes());
        fos.write(bytes1);
        //4.写一个字节数组的一部分出去
        byte[] bytes2 = "人类".getBytes();

        fos.write(bytes2,0,3);
        //5.输出换行符

        fos.write("\r\n".getBytes());
        //6.关闭（释放内存），关闭管道释放资源
        fos.close();

    }

}
