package com.luo.demo3fileinputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo1 {


    public static void main(String[] args) {
        //目标：FileInputStream的使用，文件字节输入流
        //1.创建FileInputStream对象，把文件名传递给构造方法,创建文件字节输入流管道，与源文件接通1

        try {
            InputStream fis = new FileInputStream("E:\\idea2024\\jiaoxueheima\\untitled1\\graduation_project\\src\\main\\java\\com\\luo\\秒杀系统需求.md");
            //2.使用FileInputStream对象中的方法read读取文件
            //int read() 从输入流中读取数据的下一个字节。定义一个变量记住每次读取的每一个字节
            //使用循环读取文件内容
           /* while(true){
                int b = fis.read();
                System.out.print((char)b+"  ");
                if(b==-1){
                    break;
                }
            }*/
            /*int b = 0;
            while((b=fis.read())!=-1){
                System.out.print((char)b+"  ");
            }//每次读取一个字节性能较差，而且读取汉字一定会乱码，因为汉字在utf-8编码中占三个字节，会截断汉字的字节
            //每次读多个字节，使用字节数组*/
            byte[] bytes = new byte[1024];//定义字节数组用于每次读取多个字节1kb
            //定义一个变量记录每次读取的字节个数，记录每次读取了多少个字节
            int len = 0;

            while((len=fis.read(bytes))!=-1){
                //从0到len转换成字符串，并打印，读多少打印多少
                System.out.print(new String(bytes,0,len));
            }//每次读取多个字节性能好，而且读取汉字不会乱码，
            // 每次读取多个字节可以减少磁盘和内存的交互次数，从而提升性能
            //依然无法避免输出汉字乱码的问题，存在截断汉字字节的可能性
            //解决方法：定义一个与文件一样大的字节数组，一次读完文件的全部字节
            //但是如果文件很大，导致创建的字符数组很大，就有可能存在内存溢出的可能性




            //3.释放资源
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
