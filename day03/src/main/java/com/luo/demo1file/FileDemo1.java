package com.luo.demo1file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {

        //目标：理解File类，掌握File对象的创建，搞清对文件的操作
        //File类：文件和目录路径名的抽象表示形式
        //File类位于java.io包下
        //File类提供了很多方法，用于创建和操作文件
        //File类创建对象，表示一个文件或目录
        File file = new File("C:\\Users\\HP\\Desktop\\New.docx");
        System.out.println(file.length());//获取文件大小,字节个数
        String name = file.getName();
        //绝对路径与相对路径
        //使用相对路径定义文件对象
        //只要带盘符的就是绝对路径
        //相对路径：不带盘符，默认是到你的ideal工程下直接找文件的，所以一般用来找我们工程下的项目文件
        //相对路径更好一些
        File f1=new File("day03/src/main/java/com/luo/demo1file/123");
        System.out.println(f1.length());

        //3.创建对象代表不存在的文件路径
        File f2=new File("C:\\Users\\HP\\Desktop\\New.docx");
        if (!f2.exists());{
            System.out.println("文件不存在");
            f2.createNewFile();
            System.out.println("文件已经存在");
        }
        //4.创建文件夹//mkdir只能创建一级文件夹，mkdirs可以创建多级文件夹
        File f3=new File("C:\\Users\\HP\\Desktop\\New.docx");
        if (!f3.exists());{
            System.out.println("文件夹不存在");
            f3.mkdir();
            System.out.println("文件夹已经存在");
        }
        //删除文件夹
        File f4=new File("C:\\Users\\HP\\Desktop\\New.docx");
        if (f4.exists());{
            System.out.println("文件夹存在");
            f4.delete();//只能删除空文件夹，不能删除非空文件夹，删除后的文件不会进入回收站
            System.out.println("文件夹已经删除");
        }

        //获取某个目录下的所有一级文件名
        File f5=new File("C:\\Users\\HP\\Desktop\\New.docx");
        String[] names=f5.list();
        for (String name2:names){
            System.out.println(name2);
        }
        //获取某个目录下的所有一级文件对象
        File f6=new File("C:\\Users\\HP\\Desktop\\New.docx");
        File[] files=f6.listFiles();
        for (File file2:files){
            System.out.println(file2.getAbsoluteFile());
        }

    }
}
