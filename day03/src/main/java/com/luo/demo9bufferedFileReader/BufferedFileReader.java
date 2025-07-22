package com.luo.demo9bufferedFileReader;

import java.io.*;

public class BufferedFileReader {
    //
    public static void main(String[] args) {
        //目标：了解文件缓冲字符输入流BufferedFileReader的使用

        //1.创建字符输入流与源文件接通
        //ctrl+alt+t加入try-with-resources
        try (Reader r1 = new FileReader("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo6filereader\\luo.txt");
        //2.使用字符缓冲输入流包装基础字符输入流
             BufferedReader br1 = new BufferedReader(r1);//不使用多态方便调用独有的方法

        ) {/*
            //2.定义一个字符数组，每次都多个字符
            char[] chars = new char[1024];
            //变量len记录每次读取的字符个数
            int len = 0;
            while ((len = br1.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));//不要人为换行，可以读取换行符

            }

            //文件字符输入流每次读取多个字符他的性能较好，而且他按字符读取，读取中文不会出现乱码，是读取中文的号的方式

*/


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
