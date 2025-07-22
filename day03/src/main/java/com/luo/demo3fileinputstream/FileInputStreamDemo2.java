package com.luo.demo3fileinputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {


    public static void main(String[] args) {
        //目标：FileInputStream的使用，文件字节输入流
        //缓冲字符输入流新增了一个独有功能按行读取
        //1.创建FileInputStream对象，把文件名传递给构造方法,创建文件字节输入流管道，与源文件接通1

        try {
            InputStream fis = new FileInputStream("E:\\idea2024\\jiaoxueheima\\untitled1\\graduation_project\\src\\main\\java\\com\\luo\\秒杀系统需求.md");

            //使用一次型读完文件的全部字节使用read all
            //1.使用FileInputStream对象中的方法readAllByte读取文件
            byte[] bytes = fis.readAllBytes();//底层判断，如果文件超过内存容量，直接抛出异常
            System.out.println(new String(bytes));

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//字节流适合数据的转移比如文件的复制，读文件内容更适合使用字符流
