package com.luo.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientReaderThread extends  Thread {

    private Socket s;
    DataInputStream dis = null;

    private ChatUI chatUI;//接整个聊天界面对象

    public ClientReaderThread( ChatUI chatUI,Socket s) {


        this.chatUI = chatUI;
        this.s = s;
    }

    @Override
    public void run() {
        //读取管道的消息

        try {

            //接受的消息可能有很多形式类型
            //1.在线人数更新的消息
            //2.群聊消息，包含昵称和内容
            //3.私聊消息，包含昵称和内容
            //所以客户端必须声明协议来发送消息
            //比如客户端先发1.表示接下来的是登录消息
            //比如客户端先发2.表示接下来是群聊消息
            //比如客户端先发3.表示接下来是私聊消息

            //先从输入管道，socket管道中接受客户端发来的消息类型编号
             dis = new DataInputStream(s.getInputStream());
            while (true) {
                int type = dis.readInt();//等待客服端发送数据标识
                switch (type) {

                    case 1://服务端发来的在线人数更新消息
                        updateClientOnlineCount();

                        break;

                    case 2://服务端发来的群聊消息
                       // 接收群聊数据，展示到界面的面板上去即可。

                        getToMessage();


                        break ;

                    case 3://私聊消息，接下来接受私聊消息内容数据，再把消息发送给指定客户端
                        break ;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //接收群聊数据，展示到界面的面板上去即可。
    private void getToMessage() throws Exception {
        //1.先读取群聊消息内容
        String message = dis.readUTF();
        chatUI.appendMessage(message);
    }

    //更新客户端在线人数
    private void updateClientOnlineCount() throws Exception {

        //1.先读取有多少个在线人数
        int count = dis.readInt();


        //2.循环控制读取多少个用户信息
        List<String> onlineUsers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            //3读取用户昵称
            String nickname = dis.readUTF();
            //4.将每个用户添加到集合中
            onlineUsers.add(nickname);
        }

        //3.更新到窗口界面上的右侧展示出来
        chatUI.updateOnlineCount( onlineUsers);//调用窗口的一个功能

    }


}
