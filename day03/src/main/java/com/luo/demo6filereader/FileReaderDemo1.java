package com.luo.demo6filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) {
        //目标：了解文件字符输入流FileReader的使用

        //1.创建字符输入流与源文件接通
        //ctrl+alt+t加入try-with-resources
        try (Reader r1 = new FileReader("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo6filereader\\luo.txt")) {
            //2.定义一个字符数组，每次都多个字符
            char[] chars = new char[1024];
            //变量len记录每次读取的字符个数
            int len = 0;
            while ((len = r1.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));//不要人为换行，可以读取换行符

            }

            //文件字符输入流每次读取多个字符他的性能较好，而且他按字符读取，读取中文不会出现乱码，是读取中文的号的方式


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
