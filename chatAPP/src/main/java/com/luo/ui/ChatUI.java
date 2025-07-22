package com.luo.ui;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.List;

public class ChatUI extends JFrame {
    // 界面组件定义
    private JTextArea messageArea;      // 消息展示区
    private JTextField inputField;      // 消息输入框
    private JButton sendButton;         // 发送按钮

    // 在线用户相关组件
    private JLabel onlineCountLabel;    // 在线人数标签
    private JList<String> userList;     // 用户列表
    private DefaultListModel<String> userModel; // 用户列表模型

    // 业务相关属性
    private  String nickname;      // 用户昵称
    private Set<String> onlineUsers = new HashSet<>(); // 在线用户集合
    private Socket socket;

    public ChatUI(){
        initUI();
        this.setVisible(true);

    }
    // 构造方法//将登陆界面的昵称和Socket对象传入
    public ChatUI(String nickname, Socket  socket) {
        this.nickname = nickname;


        //this()调用兄弟构造方法
        this.socket=socket;
        initUI();

        //立即把客户端的这个socket管道交给一个独立的线程专门读取从客户端socket从服务端收到的在线人数更新数据和群聊消息数据。
       //把整个窗口对象也送给线程处理方便后续的数据传递
        new ClientReaderThread(  this,socket).start();








        setupEventListeners();//添加事件监听
        this.setVisible(true);//显示界面
        //addSampleUsers(); // 测试数据

    }


    // 初始化UI组件
    private void initUI() {
        // 设置窗口属性
        setTitle("局域网聊天室 - " + nickname);//立马展示昵称到窗口
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出程序
        setLocationRelativeTo(null);
        setResizable(false);


        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));

        // 创建消息展示区域
        createMessageArea();

        // 创建输入面板
        JPanel inputPanel = createInputPanel();

        // 创建用户列表面板
        JPanel userPanel = createUserListPanel();

        // 创建消息区域和用户列表的分割面板
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(messageArea),
                userPanel
        );
        splitPane.setDividerLocation(550); // 设置初始分割位置
        splitPane.setResizeWeight(0.7);   // 设置调整比例
        splitPane.setOneTouchExpandable(true);

        // 添加组件到主窗口
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // 设置主面板为内容窗格
        setContentPane(mainPanel);
    }

    // 创建消息展示区域
    private void createMessageArea() {
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        messageArea.setLineWrap(true);      // 自动换行
        messageArea.setWrapStyleWord(true); // 按单词换行
    }

    // 创建输入面板
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        inputField = new JTextField();
        inputField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        inputField.setPreferredSize(new Dimension(0, 40)); // 设置高度

        sendButton = new JButton("发送");
        sendButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        sendButton.setBackground(new Color(70, 130, 180));
        sendButton.setForeground(Color.WHITE);
        sendButton.setPreferredSize(new Dimension(80, 40));

        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        return panel;
    }

    // 创建用户列表面板
    private JPanel createUserListPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "在线用户",
                TitledBorder.LEFT, TitledBorder.TOP
        ));

        // 创建用户列表模型
        userModel = new DefaultListModel<>();
        userList = new JList<>(userModel);
        userList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 创建在线人数标签
        onlineCountLabel = new JLabel("当前在线人数: 0");
        onlineCountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        onlineCountLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // 添加到面板
        panel.add(onlineCountLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(userList), BorderLayout.CENTER);
        return panel;
    }

    // 设置事件监听
    private void setupEventListeners() {
        // 发送按钮点击事件
        sendButton.addActionListener(e -> sendMessage());

        // 输入框回车事件
        inputField.addActionListener(e -> sendMessage());

      /*  // 测试用：模拟在线人数更新（实际应由服务器提供）
        Timer timer = new Timer(2000, e -> {
            // 随机增减用户
            if (Math.random() > 0.5 && onlineUsers.size() < 10) {
                String newUser = "用户" + (onlineUsers.size() + 1);
                onlineUsers.add(newUser);
                userModel.addElement(newUser);
            } else if (onlineUsers.size() > 1) {
                String removedUser = new ArrayList<>(onlineUsers).get(
                        new Random().nextInt(onlineUsers.size()));
                onlineUsers.remove(removedUser);
                userModel.removeElement(removedUser);
            }
           // updateOnlineCount();
        });
        timer.start();*/
    }

    // 发送消息处理方法
    private void sendMessage() {
        String content = inputField.getText().trim();//获取输入框内容并去除空格
        if (content.isEmpty()) return;

        // 清空输入框
        inputField.setText("");

        //发送消息
        //1.从socket中获取一个特殊数据输出流
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //2.把消息发送给服务端，先发消息类型2，再发数据
            dos.writeInt(2);
            dos.writeUTF(content);
            //3.刷新数据
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 滚动到底部
        messageArea.setCaretPosition(messageArea.getDocument().getLength());//每次添加消息后滚动到底部
    }

    // 添加消息到展示区
    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            messageArea.append(message + "\n");//服务端发送的消息自带换行这里其实可以不用换行
        });
    }

    // 更新在线人数显示
    public void updateOnlineCount(List <String> users) {
        //把线程读取到的在线用户名称展示到界面上
        userModel.clear();
        for (String user : users) {
            userModel.addElement(user);
        }
        SwingUtilities.invokeLater(() -> {
            onlineCountLabel.setText("当前在线人数: " + userModel.getSize());
        });
    }

    // 添加测试用户
    private void addSampleUsers() {
        String[] testUsers = {"Alice", "Bob", "Charlie", "David", "Eva"};
        for (String user : testUsers) {
            onlineUsers.add(user);
            userModel.addElement(user);
        }
        //updateOnlineCount();
    }

    // 主方法用于测试
    public static void main(String[] args) {
       new ChatUI();
    }
}