package com.luo.demo14commonsioDemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;//jdk1.7开始的新io技术

public class CommonsIoDemo {
    public static void main(String[] args) {
        //目标：commons-io，io框架的使用
        try {//底层基于新io的技术实现
            FileUtils.copyFile(new File("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo14commonsioDemo\\123.txt"),
                    new File("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo14commonsioDemo\\1234.txt"));

        //java中也提供了一行代码从jdk1.7开始，可以直接使用//但因为功能太弱大家还是使用commons-io框架

            Files.copy(new File("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo14commonsioDemo\\123.txt").toPath(), new File("E:\\idea2024\\jiaoxueheima\\untitled1\\day03\\src\\main\\java\\com\\luo\\demo14commonsioDemo\\1234.txt").toPath());


        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
