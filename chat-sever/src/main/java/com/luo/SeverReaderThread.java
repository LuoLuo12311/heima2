package com.luo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class SeverReaderThread extends  Thread {

    private Socket s;

    public SeverReaderThread(Socket s) {


        this.s = s;
    }

    @Override
    public void run() {
        //读取管道的消息

        try {

            //接受的消息可能有很多形式类型
            //1.登录消息，包含昵称
            //2.群聊消息，包含昵称和内容
            //3.私聊消息，包含昵称和内容
            //所以客户端必须声明协议来发送消息
            //比如客户端先发1.表示接下来的是登录消息
            //比如客户端先发2.表示接下来是群聊消息
            //比如客户端先发3.表示接下来是私聊消息

            //先从输入管道，socket管道中接受客户端发来的消息类型编号
            DataInputStream dis = new DataInputStream(s.getInputStream());
            while (true) {
                int type = dis.readInt();//等待客服端发送数据标识
                switch (type) {

                    case 1://登录消息，接下来接受昵称数据，再更新全部客户端的在线人数列表
                        String nickname = dis.readUTF();
                        //把这个登录成功的socket存入到在线集合
                        Sever.onlineClients.put(s,nickname);
                        //更新全部客户端的在线人数列表
                        updateOnlineCount();
                        System.out.println("客户端登录成功:" + nickname);
                        System.out.println("=======================================");
                        break;

                    case 2://群聊消息，接下来接受群聊消息内容数据，再把消息发送给全部客户端
                        System.out.println("群聊消息");
                        String s1 = dis.readUTF();
                        sendMsgToAll(s1);
                        break ;

                    case 3://私聊消息，接下来接受私聊消息内容数据，再把消息发送给指定客户端
                        System.out.println("私聊消息");
                        //接收私聊消息私聊对象
                        String somebody = dis.readUTF();
                        String s2 = dis.readUTF();
                        sendMsgToSomebody(  somebody,s2);
                        break ;

                }
            }
        } catch (Exception e) {
            //追踪下线逻辑//将异常信息显示更换为下线提示
            System.out.println("客户端下线"+s.getInetAddress().getHostAddress()+":"+s.getPort());
            Sever.onlineClients.remove(s);//把下线客户端从在线列表中删除
            updateOnlineCount();//更新在线人数列表

        }
    }

    //给指定客户端推送当前客户端发来的消息
    private void sendMsgToSomebody( String somebody,String s2) {

        //一定要拼装好这个消息再发送给全部socket，使用高效字符串拼接
        StringBuffer sb = new StringBuffer();
        String name = Sever.onlineClients.get(s);


        //获取当前时间
        //时间使用LocalDateTime.now()获取
        LocalDateTime now = LocalDateTime.now();
        //格式化时间
        String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a"));



        //拼接消息
        String msgResult = sb.append(name).append("  ").append(time).append("\r\n")
                .append(s2).append("\r\n").toString();

        //将拼接好的消息推送给指定在线客户端
         for (Socket socket: Sever.onlineClients.keySet()) {
             try {
                 if (socket.toString().equals(somebody)) {
                     continue;
                 }
                 DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                 dos.writeInt(3);//通知客户端接下来是私聊消息，规定标识为3
                 dos.writeUTF(msgResult);
                 dos.flush();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }


    }

    //给全部客户端推送当前客户端发来的消息
    private void sendMsgToAll(String s1) {

        //一定要拼装好这个消息再发送给全部socket，使用高效字符串拼接
        StringBuffer sb = new StringBuffer();
        String name = Sever.onlineClients.get(s);


        //获取当前时间
        //时间使用LocalDateTime.now()获取
        LocalDateTime now = LocalDateTime.now();
        //格式化时间
        String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a"));



        //拼接消息
        String msgResult = sb.append(name).append("  ").append(time).append("\r\n")
                .append(s1).append("\r\n").toString();





        //将拼接好的消息推送给指定在线客户端
        for (Socket socket: Sever.onlineClients.keySet()) {
            try {
                //将拼接好的消息推送给指定在线客户端
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2);//通知客户端接下来是群聊消息，规定标识为2 //群聊消息标识为2//


                dos.writeUTF(msgResult);


                dos.flush();//刷新数据把数据马上推给客户端
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

    private void updateOnlineCount() {
      //更新全部客户端的在线人数列表
        //1.拿到全部在线客户端的用户名称
        Collection<String> onLineUserName = Sever.onlineClients.values();
        //2.把所有在线用户名称发送给全部在线客户端
        for (Socket socket: Sever.onlineClients.keySet()) {
            try {
                //3.把集合中的所有用户名称发送给当前在线客户端
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(1);//通知客户端接下来是在线人数列表消息，规定标识为1   //群聊消息标识为2//


                dos.writeInt(onLineUserName.size());//告诉客户端接下来要发多少个用户名称
                for (String name : onLineUserName) {
                    dos.writeUTF(name);
                }
                dos.flush();//刷新数据把数据马上推给客户端
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
