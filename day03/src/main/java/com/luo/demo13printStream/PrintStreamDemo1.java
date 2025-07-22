package com.luo.demo13printStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo1 {
    public static void main(String[] args) {

        //目标：打印流的使用
        try (//如果要追加内容而不是覆盖内容就不要使用这种直接通向文件的构造方法，先构建低级管道，低级管道使用ture参数再包装低级管道
                PrintStream ps = new PrintStream("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo13printStream\\123.txt")


        ) {

            ps.println("hello world");
            ps.println(123);
            ps.println(true);//打印是啥就是是啥，所见即所得，而且性能好速度快
            //淘汰了之前的输出流


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
