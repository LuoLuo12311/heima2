package com.luo.list;

import java.util.ArrayList;

public class ListDemo2ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //目标；arraylist的底层原理：基于数组存取数据
        //特点：查询速度块，增删效率低
        //连续的地址空间中存储
        //对于arraylist底层的数组实现来说数组第一次添加元素时数组长度扩容，会创建一个长度为10的数组
        //之后达到限制后每次扩容1.5倍，例如10到15

        list.add("hello");
    }
}
