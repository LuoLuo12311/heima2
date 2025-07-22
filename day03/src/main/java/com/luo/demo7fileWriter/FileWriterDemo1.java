package com.luo.demo7fileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//注意：字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效
//因为缓冲流，数据写出去后，并不是直接写出去，而是先写入缓冲区，等到缓冲区满了，或者关闭流，才会将数据写出去
public class FileWriterDemo1 {
    public static void main(String[] args) {
        //目标:了解文件字符输出流，file writer的使用
        try (Writer w1 = new FileWriter("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo7fileWriter\\luo1.txt", true)) {

            w1.write("hello world");
            //他做换行更加方便
            w1.write("\r\n");
            w1.write("hello world2");
            w1.write("\r\n");

            //写一个字符
            w1.write('a');
            //写一个字符数组
            char[] chars = {'a','b','c'};
            w1.write("\r\n");

            w1.write(chars);
            //写一个字符数组的一部分
            w1.write(chars,0,2);//结尾加一个ture参数，表示追加，否则表示复制
            w1.write("\r\n");

            //写一个字符串的一部分
            w1.write("hello world",0,5);

            //刷新
            w1.flush();//刷新缓冲区，将数据写入到目的地//刷新后流继续使用，不会清空缓冲区，不会关闭
            w1.close();//关闭流//关闭包含了刷新，不能继续使用
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
