package com.luo.demo1inetAddress;

import java.net.InetAddress;

/**对于IP地址的表示方法
 * IPv4采用点分十进制表示法，IPv6采用冒分16进制表示法
 * IP域名将容易记的域名映射到数字化的IP地址
 */

/**内网与公网IP
 * 公网是可以链接到互联网的IP
 * 内网是局域网IP，例如192.168.1.1
 * 本机IP
 * 127.0.0.1
 *  localhost
 */

/**
 * IP常用命令
 * ipconfig   ipconfig/all   查看本机IP地址
 *MAC地址/物理地址，与电脑绑定相对唯一识别
 * ping IP 地址：检查网络是否联通
 */
public class InetAddressDemo1 {
    public static void main(String[] args) {
        //目标：认识InetAddress类，获取本机IP对象和对方IP对象
        try {
            //1获取本机IP对象
            InetAddress ip = InetAddress.getLocalHost();//获得主机名和IP地址
            System.out.println(ip);//获得主机名和IP地址
            System.out.println(ip.getHostName());//获得主机名
            System.out.println(ip.getHostAddress());//获得IP地址
            //2获取对方IP对象
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");//拿百度的ip地址对象

            System.out.println(ip2);
            System.out.println(ip2.getHostName());
            System.out.println(ip2.getHostAddress());
            //3.判断本机与对方主机是否互通
            System.out.println(ip2.isReachable(2000));//2000毫秒内接通会返回true，否则返回false
            //相当与ping 命令
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
//ip定位主机，端口定位程序，标记应用程序的表示，被规定为十六位的二进制数范围：0-65535
