package com.luo.demo2recusion;

import java.io.File;

public class FileSearchTest2 {
    public static void main(String[] args) {
        //目标：理解递归的无公式，文件搜索找出文件
        File dir=new File("D:\\");

        findFile(dir,".java");


    }

    /**
     * 搜索文件
     * @param dir 搜索目录
     * @param name 搜索文件名
     *///------------------------------------标准注释快捷建“/**”然后回车
    //递归方法搜索文件，碰到文件夹就递归
    public static void findFile(File dir,String name) {

        //1判断极端情况
        if (!dir.isDirectory()||dir== null||!dir.exists()) {
            return;
        }
        //2获取目录下的所有一级文件或者文件夹
        File[] files=dir.listFiles();
        //3判断当前目录下是否存在一级文件对象，然后才可以遍历
        if (files!=null&&files.length>0) {
            for (File file:files) {
                if (file.isFile()&&file.getName().contains(name)) {//判断文件名是否包含name，模糊查询
                    System.out.println("找到文件："+file.getName());
                    System.out.println(file.getAbsolutePath());
                }else if (file.isDirectory()) {
                    findFile(file,name);
                }
            }
        }

    }
}
