package com.luo.demo11inputStreamReader;

import java.io.*;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) {



        //演示一个问题：不同编码读取乱码的问题
        //当文本是utf-8编码时可以正常读取，但当将文本转为gbk编码时，会出现中文乱码
        //解决方法，使用inputStreamReader解决乱码问题（字符输入转换流），解决不同编码时，字符流读取文本内容乱码问题
        //先读取文件的原始字节流，再将其按照真是的字符集拜尼马转换成字符流，这样就不会乱码了

        try (Reader r1 = new FileReader("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo11inputStreamReader\\luo2.txt");
             //2.使用字符缓冲输入流包装基础字符输入流
             BufferedReader br1 = new BufferedReader(r1);//不使用多态方便调用独有的方法

        ) {


            //使用循环改进来按行读取文件
            String line = null;//定义一个字符串变量用于记住每行读取的内容
            while ((line = br1.readLine()) != null) {
                System.out.println(line);
            }//目前读取文本最优雅的方案：首先性能较好，无乱码，还可以按行读取




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
