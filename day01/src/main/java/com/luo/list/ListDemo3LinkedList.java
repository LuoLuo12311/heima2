package com.luo.list;

import java.util.LinkedList;
import java.util.Stack;
//相比于array list，linked list的查询效率更低，增删效率高，更加占内存
public class ListDemo3LinkedList {
    public static void main(String[] args) {
        //目标：集合掌握LinkedList的底层原理，特点以及linkedlist的应用
        //底层原理：基于双链表链表实现
        //应用场景一：设计队列：先进先出
        //应为队列只在首尾增删数据，所以底层使用双链表的linked list更合适实现
        LinkedList<String> queue= new LinkedList<>();
        //入队
        queue.addLast("hello");

        queue.addLast("world");
        queue.addLast("java");
        System.out.println(queue);
        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);


        //应用场景二：使用linked list设计栈：后进先出，先进后出
        //子弹弹匣
        LinkedList<String> stack = new LinkedList<>();
        stack.addFirst("第一颗子弹");
        stack.addFirst("第二颗子弹");

        stack.addFirst("第三颗子弹");
        System.out.println(stack);//第三科子弹放在第一个位置代表压栈成功
        //弹栈，出栈
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack);
        //java也知道linked list可以做栈，所以兼容了栈的api
        //直接使用pop，与push
        //push就是调用的 addFirst，pop就是调用的removeFirst
        stack.push("第一颗子弹");
        stack.push("第二颗子弹");
        stack.push("第三颗子弹");
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
