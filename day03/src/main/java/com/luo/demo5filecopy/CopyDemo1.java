package com.luo.demo5filecopy;


//因为这种资源释放的方式太过于臃肿，所以jdk7以后提供了try with resources

import java.io.*;

//字节流非常适合复制图片，视频，音频等大文件，字节流适合复制文本文件，非常适合做文件的复制
public class CopyDemo1 {
    public static void main(String[] args)  {
        //目标：使用字节流完成文件复制
        /*//源文件路径：E:\idea2024\jiaoxueheima//untitled1\day03\src\main\java\com\luo\demo4fileoutputstream\tupian.png*/

        //目标位置：E:\idea2024\jiaoxueheima//untitled1\day03\src\main\java\com\luo\demo5filecopy//new.png（复制过去的时候一定要带文件名，他无法自动生成文件名）

        copyFile("day03//src//main//java//com//luo//demo4fileoutputstream//tupian.png","day03//src//main//java//com//luo//demo5filecopy//new.png");

    }
    //复制方法
    public static void copyFile(String srcPath,String destPath)  {
        //为了解决管道在try这个局部代码快中不能在finally中调用方法的问题，先在外面定义变量，再在try里面调用变量赋值



//因为这种资源释放的方式太过于臃肿，所以jdk7以后提供了try with resources
        try (InputStream fs=new FileInputStream(srcPath);
             OutputStream os=new FileOutputStream(destPath)){
            //资源放到这小括号里，，这里只能放置资源对象，用完后会自动调用close方法
            //资源一般是实现了一个Closeable接口的类对象
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=fs.read(bytes))!=-1){
                os.write(bytes,0,len);
                System.out.println("复制成功");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}//ctr+alt+t快捷添加try catch
//自定义的资源对象
class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("关闭资源");
    }
}
