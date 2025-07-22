package com.luo.demo7TCP4_BS;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPSever {
    public static void main(String[] args) throws Exception {
        //目标：BS架构的原理

        System.out.println("服务端启动成功");
        //使用一个死循环，让主线程不断负责接受客户端链接，然后将链接创建好的管道，交给一个个子线程来完成
        //这样就实现了多个客户端连接


        //1.创建一个ServerSocket对象，指定端口号

        ServerSocket ss = new ServerSocket(8080);//注册端口8080方便浏览器寻找
        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(3,1,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        //死循环，让主线程不断接受客户端连接接受管道
        while (true) {
            //2.调用accept接收方法阻塞等待客户端链接，一旦有客户短链接，会返回一个socket对象。
            Socket s = ss.accept();
            System.out.println(//追踪上线逻辑
                    "一个客户端上线了"+s.getInetAddress().getHostAddress()+":"+s.getPort()
            );


            //使用线程池进行与网页短链接的优化
            //3.把客户端的管道都包装成一个任务/runnable对象或者一个callable对象交给线程池处理
            //这里进行一个补充：线程对象可以直接做为任务因为他本身继承了一个runnable的接口，，所以他既可以启动线程也可以作为一个任务对象交给线程池来处理

            pool.execute(new SeverReader(s));



        }


    }
}
