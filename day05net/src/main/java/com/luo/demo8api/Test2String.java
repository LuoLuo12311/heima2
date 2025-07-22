package com.luo.demo8api;

public class Test2String {
    public static void main(String[] args) {
        //目标：高效拼接字符串

        //传统方式拼接：
        //因为使用加号拼接字符串内容性能较差(使用+拼接内容，如果是大量拼接效率极差)
        //因为String的对象是不可变对象，每次拼接都会放弃原来的对象创建新的对象，内存中不断产生垃圾对象
        //共享数据性能可以，但是修改数据性能差
      /*  String s1 = "";
        for (int i = 0; i < 1000000; i++) {
            s1 += "abc";
        }

        System.out.println(s1);*/


        //定义字符串可以使用String类型，但是操作字符串建议使用StringBuilder（性能更好）
        //新方法高效拼接字符串：
        StringBuilder sb = new StringBuilder();//对象是可变内容的容器sb= ""
        for (int i = 0; i < 100000; i++) {
            //始终只在一个对象中追加内容
            sb.append("abc");
        }
        //StringBuilder只是拼接字符串的手段，最终结果还是要要转换成String字符串
        String s2 = sb.toString();
        System.out.println(s2);

        //StringBuilder可以支持链式编程

        String s3 = new StringBuilder().append("luo").append("kai").append("yuan").toString();
        System.out.println(s3);
    }
}
