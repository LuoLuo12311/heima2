package com.luo.demo11inputStreamReader;

import java.io.*;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class InputStreamReaderDemo2 {
    public static void main(String[] args) {



        //目标：使用字符输入转换流InputStringReader解决不同编码读取乱码问题
        //当文本是utf-8编码时可以正常读取，但当将文本转为gbk编码时，会出现中文乱码
        //解决方法，使用inputStreamReader解决乱码问题（字符输入转换流），解决不同编码时，字符流读取文本内容乱码问题
        //先读取文件的原始字节流，再将其按照真是的字符集拜尼马转换成字符流，这样就不会乱码了

        //2.指定编码把字节流转换成字符流
        //使用GBK编码转成字符流
        //不使用多态方便调用独有的方法
        try (InputStream is = new FileInputStream("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo11inputStreamReader\\luo2.txt")) {

                try (Reader r2 = new InputStreamReader(is, "GBK")) {
                    try (BufferedReader br1 = new BufferedReader(r2)) {


                    //使用循环改进来按行读取文件
                    String line = null;//定义一个字符串变量用于记住每行读取的内容
                    while ((line = br1.readLine()) != null) {
                        System.out.println(line);
                    }//目前读取文本最优雅的方案：首先性能较好，无乱码，还可以按行读取


                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
