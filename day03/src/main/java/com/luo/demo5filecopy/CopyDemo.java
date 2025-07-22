package com.luo.demo5filecopy;


//因为这种资源释放的方式太过于臃肿，所以jdk7以后提供了try with resources

import java.io.*;
//字节流非常适合复制图片，视频，音频等大文件，字节流适合复制文本文件，非常适合做文件的复制
public class CopyDemo {
    public static void main(String[] args)  {
        //目标：使用字节流完成文件复制
        /*//源文件路径：E:\idea2024\jiaoxueheima//untitled1\day03\src\main\java\com\luo\demo4fileoutputstream\tupian.png*/

        //目标位置：E:\idea2024\jiaoxueheima//untitled1\day03\src\main\java\com\luo\demo5filecopy//new.png（复制过去的时候一定要带文件名，他无法自动生成文件名）

        copyFile("day03//src//main//java//com//luo//demo4fileoutputstream//tupian.png","day03//src//main//java//com//luo//demo5filecopy//new.png");

    }
    //复制方法
    public static void copyFile(String srcPath,String destPath)  {
        //为了解决管道在try这个局部代码快中不能在finally中调用方法的问题，先在外面定义变量，再在try里面调用变量赋值

        InputStream fs=null;
        OutputStream os=null;
        try {
            //创建文件字节输入与输出流分别与源文件接通，和与目文件接通
             fs=new FileInputStream(srcPath);
             os=new FileOutputStream(destPath);
            //读取一个字节数组，写入一个字节数组
            byte[] bytes = new byte[1024];
            int len = 0;//定义一个变量记录每次读取的字节个数
            while((len=fs.read(bytes))!=-1){
                os.write(bytes,0,len);//根据每次读取的字节长度，读多少字节，写多少字节
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("复制成功");
            //最后一定会执行一次，避免了因程序发生异常中断而无法关闭流的情况
              //释放资源
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fs == null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }//担心空指针异常,加上判断//并且单独try catch
            //为了解决管道在try这个局部代码快中不能在finally中调用方法的问题，先在外面定义变量，再在try里面调用变量赋值

        }

    }
}//ctr+alt+t快捷添加try catch
