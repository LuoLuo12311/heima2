package com.luo.collection;

import java.util.ArrayList;
import java.util.Iterator;

//遍历并删除的操作无索引的集合只能使用迭代器进行遍历
public class CollectionTraversalTest4 {
    public static void main(String[] args) {
        //目标：集合掌握认识并发修改异常问题，搞清三种遍历之间的区别
        ArrayList<String> list = new ArrayList<>();

        list.add("枸杞");
        list.add("枸杞干");
        list.add("人字拖");
        list.add("枸杞 seeds");
        list.add("java");
        System.out.println(list);
        //需求：删除全部枸杞
       /* for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        }

        System.out.println(list);//打印结果来看并没有删除干净，*/
        //出现了并发修改异常问题
        //遍历集合的同时又存在增删集合的元素的行为时可能会出现业务异常，这种现象称为并发修改异常
        //原因是：集合对象在遍历的过程中，集合对象被修改了，导致集合对象内部数据结构被破坏了
        //即当删掉第一个包含枸杞的元素时，第二个包含枸杞元素向前移动，而索引则正常加1，导致遗漏检查这个元素
        //解决方式：第一种：删除数据后做一步i--操作
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("枸杞")) {
                list.remove(s);
                i--;
            }
        }
        System.out.println(list);
        System.out.println("=======================================");



        ArrayList<String> list1 = new ArrayList<>();

        list1.add("枸杞");
        list1.add("枸杞干");
        list1.add("人字拖");
        list1.add("枸杞 seeds");
        list1.add("java");
        System.out.println(list1);
        //第二种解决方案，倒着遍历并删除(前提是支持索引)
        for(int i = list1.size() - 1; i >= 0; i--){
            String s = list1.get(i);
            if(s.contains("枸杞")){
                list1.remove(i);
            }
        }
        System.out.println(list1);


        System.out.println("=======================================");



        ArrayList<String> list2 = new ArrayList<>();

        list2.add("枸杞");
        list2.add("枸杞干");
        list2.add("人字拖");
        list2.add("枸杞 seeds");
        list2.add("java");
        System.out.println(list2);
        //面对没有索引的集合，如何遍历

        //方案一：使用迭代器遍历并删除，默认也存在并发修改异常问题
        //解决方法：使用迭代器自己的方法来解决

        Iterator<String> it = list2.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(s.contains("枸杞")){
                it.remove();
            }

        }
        System.out.println(list2);


        System.out.println("=======================================");



        ArrayList<String> list3 = new ArrayList<>();

        list3.add("枸杞");
        list3.add("枸杞干");
        list3.add("人字拖");
        list3.add("枸杞 seeds");
        list3.add("java");
        System.out.println(list3);
        //面对没有索引的集合，如何遍历

        //方案二和三：使用增强for和lambda，也都存在并发修改异常问题
        //解决方法：都无法解决，只能使用迭代器
        //因为这两种方法的本质都还是基于迭代器实现的，但是又无法直接调用迭代器的remove方法所以并发修改异常问题无法解决

        Iterator<String> it2 = list3.iterator();
        while(it2.hasNext()){
            String s = it2.next();
            if(s.contains("枸杞")){
                it2.remove();
            }

        }
        System.out.println(list3);
    }
}
