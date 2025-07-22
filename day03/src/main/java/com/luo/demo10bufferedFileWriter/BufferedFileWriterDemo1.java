package com.luo.demo10bufferedFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//注意：字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效

public class BufferedFileWriterDemo1 {
    //
    public static void main(String[] args) {
        //目标:了解文件缓冲字符输出流，buffered file writer的使用
        //缓冲字符输出流也多了一个独有的方法，换行输出

        try (Writer fw = new FileWriter("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo7fileWriter\\luo1.txt", true);
             //1.使用缓冲字符输出流对普通字符输出流进行包装
             BufferedWriter bw = new BufferedWriter(fw);//不用多态方便调用独有的方法
             //快捷建：shift+f6全选相同变量再进行修改
             //低级管道决定特性，高级管道决定性能，因为低级管道不是覆盖而是追加，所以包装后的高级管道也是追加类型




        ) {

            bw.write("hello world");
            //他做换行更加方便
            bw.newLine();//独有方法换行

            bw.write("hello world2");
            bw.newLine();//独有方法换行

            //写一个字符
            bw.write('a');
            //写一个字符数组
            char[] chars = {'a','b','c'};
            bw.newLine();//独有方法换行


            bw.write(chars);
            //写一个字符数组的一部分
            bw.write(chars,0,2);//结尾加一个ture参数，表示追加，否则表示复制
            bw.newLine();//独有方法换行


            //写一个字符串的一部分
            bw.write("hello world",0,5);

            //刷新
            bw.flush();//刷新缓冲区，将数据写入到目的地//刷新后流继续使用，不会清空缓冲区，不会关闭
            bw.close();//关闭流//关闭包含了刷新，不能继续使用
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
