package com.luo.demo1hashset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo4 {
    public static void main(String[] args) {
        //目标：了解TreeSet集合对于自定义对象的排序
        //底层原理：红黑树进行的排序
        //对于数值类型Int，Integer，Long，Date，包装类，会自动进行排序按照数值本身大小进行排序
        //String对于字符串类型按照首字符的编号升序排序
        //对于自定义类型如Student，TreeSet默认是无法直接排序的
        //所以对于对象类型，会调用对象中的compareTo方法进行排序

        Set<Teacher> s1 = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            //2.让tree set集合自带的比较器comparator对象，指定比较规则
            public int compare(Teacher o1, Teacher o2) {

//                return o1.getAge() - o2.getAge();
                //薪水比较(调包装类的方法)
                return  Double.compare(o1.getScore(), o2.getScore());
                //如果想保留两个比较值相等的不同对象，就不要，return 0
            }
        });
        //简化
        //Set<Teacher> s1 = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge() );



        //一定要排序，不排序就会报错
        //对象和集合都有排序规则的情况下，优先使用集合规则排序
        s1.add(new Teacher("小王", 18, 90.0));
        s1.add(new Teacher("小张", 19, 80.0));
        s1.add(new Teacher("小李", 17, 70.0));
        s1.add(new Teacher("小王", 18, 90.0));
        //对于自定义类型如Student，TreeSet默认是无法直接排序的因为没有大小规则
        //如果一定要解决有两种方案
        //1.让对象类实现Comparable接口，并重写compareTo方法制定比较规则
        //2.让tree set集合自带的比较器comparator对象，指定比较规则

        System.out.println(s1);

    }
}
