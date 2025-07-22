package com.luo.basicdemo.basicdemo;

import com.luo.basicdemo.basicdemo.Movie;
import com.luo.basicdemo.basicdemo.MovieManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MovieManagerGUI extends JFrame {
    private MovieManager movieManager = new MovieManager();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> movieList = new JList<>(listModel);

    public MovieManagerGUI() {
        setTitle("电影信息管理系统");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 电影列表面板
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("电影列表"));
        movieList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(movieList);
        listPanel.add(scrollPane, BorderLayout.CENTER);
        add(listPanel, BorderLayout.CENTER);

        // 操作按钮面板
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("上架电影");
        JButton removeByNameBtn = new JButton("下架指定电影");
        JButton removeByActorBtn = new JButton("下架主演相关电影");
        JButton refreshBtn = new JButton("刷新列表");
        buttonPanel.add(addBtn);
        buttonPanel.add(removeByNameBtn);
        buttonPanel.add(removeByActorBtn);
        buttonPanel.add(refreshBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // 添加电影
        addBtn.addActionListener(e -> {
            JTextField nameField = new JTextField();
            JTextField actorField = new JTextField();
            Object[] message = {
                    "电影名:", nameField,
                    "主演:", actorField
            };
            int option = JOptionPane.showConfirmDialog(this, message, "上架电影", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText().trim();
                String actor = actorField.getText().trim();
                if (!name.isEmpty() && !actor.isEmpty()) {
                    movieManager.addMovie(new Movie(name, actor));
                    refreshMovieList();
                } else {
                    JOptionPane.showMessageDialog(this, "电影名和主演不能为空！");
                }
            }
        });

        // 下架指定电影
        removeByNameBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "请输入要下架的电影名:");
            if (name != null && !name.trim().isEmpty()) {
                boolean removed = movieManager.removeMovieByName(name.trim());
                if (removed) {
                    JOptionPane.showMessageDialog(this, "下架成功！");
                } else {
                    JOptionPane.showMessageDialog(this, "未找到该电影！");
                }
                refreshMovieList();
            }
        });

        // 下架主演相关电影
        removeByActorBtn.addActionListener(e -> {
            String actor = JOptionPane.showInputDialog(this, "请输入要下架的主演:");
            if (actor != null && !actor.trim().isEmpty()) {
                int count = movieManager.removeMoviesByActor(actor.trim());
                JOptionPane.showMessageDialog(this, "共下架" + count + "部相关电影。");
                refreshMovieList();
            }
        });

        // 刷新列表
        refreshBtn.addActionListener(e -> refreshMovieList());

        // 初始刷新
        refreshMovieList();
    }

    private void refreshMovieList() {
        listModel.clear();
        List<Movie> movies = movieManager.getAllMovies();
        for (Movie m : movies) {
            listModel.addElement(m.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieManagerGUI().setVisible(true));
    }
} 