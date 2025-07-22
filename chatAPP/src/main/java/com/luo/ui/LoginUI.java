package com.luo.ui;

import com.luo.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoginUI extends JFrame {
    // 定义界面组件
    private JTextField nicknameField;
    private JButton loginButton;
    private JButton cancelButton;

    // 构造方法
    public LoginUI() {
        // 初始化界面
        initUI();
    }

    private void initUI() {
        // 设置窗口属性
        setTitle("局域网聊天 - 登录");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        setResizable(false); // 禁止调整大小

        // 使用BorderLayout布局
        setLayout(new BorderLayout(10, 10));

        // 创建顶部面板
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel label = new JLabel("请输入您的昵称:");
        nicknameField = new JTextField(15);
        topPanel.add(label);
        topPanel.add(nicknameField);

        // 创建底部面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        loginButton = new JButton("登录");//登录按钮
        cancelButton = new JButton("取消");

        // 添加按钮事件监听
        loginButton.addActionListener(e -> handleLogin());//登录按钮点击事件
        cancelButton.addActionListener(e -> System.exit(0));

        // 添加回车键事件支持
        nicknameField.addActionListener(e -> handleLogin());

        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);

        // 添加到主窗口
        add(topPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 设置样式
        applyStyles();
    }

    private void applyStyles() {
        // 设置字体
        Font font = new Font("微软雅黑", Font.PLAIN, 14);
        nicknameField.setFont(font);
        loginButton.setFont(font);
        cancelButton.setFont(font);

        // 设置按钮颜色
        loginButton.setBackground(new Color(100, 180, 100));
        loginButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(180, 100, 100));
        cancelButton.setForeground(Color.WHITE);

        // 设置边框
        nicknameField.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
    }

    //登录事件处理独立成方法，不显臃肿
    private void handleLogin()  {
       // String.trim() 方法用于去除字符串两端的空白字符（包括空格、换行、制表符等），返回处理后的新字符串。
        // 该方法不会修改原字符串对象，
        String nickname = nicknameField.getText().trim();//获取昵称

        
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "昵称不能为空，请输入您的昵称！", 
                "提示", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (nickname.length() > 15) {
            JOptionPane.showMessageDialog(this, 
                "昵称过长，最多允许15个字符", 
                "错误", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 立即发送登录消息给服务端程序
            //1.请求一个socket对象，建立与服务端的链接
            Socket socket = new Socket( Constant.SERVER_IP, Constant.SERVER_PORT);//底层异常向外抛出
            System.out.println("登录成功，昵称: " + nickname);

            //2.立即发送消息类型1，和自己的昵称给服务端
            //因为服务端用的特殊数据输入流所以这里使用DataOutputStream
            //界面与界面之间传递数据
            new DataOutputStream(socket.getOutputStream()).writeInt(1);
            new DataOutputStream(socket.getOutputStream()).writeUTF(nickname);
            //刷新管道（不能关闭管道）
            new DataOutputStream(socket.getOutputStream()).flush();
            // 关闭登录界面
            dispose();

            // 打开聊天界面（后续实现），启动聊天界面，把昵称传给聊天界面，
            // 通信管道也要传给聊天界面，后续聊天界面直接使用此通信管道与服务段通信
            new ChatUI(nickname, socket);


            // new ChatUI(nickname).setVisible(true);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 在事件调度线程中创建界面
        SwingUtilities.invokeLater(() -> {
            LoginUI login = new LoginUI();
            login.setVisible(true);
        });
    }
}