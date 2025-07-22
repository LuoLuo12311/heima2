package com.luo.demo2reflection;

public class ReflectionDemo {
    public static void main(String[] args) {
        //目标：掌握反射第一步操作获取类的class对象(获取类本身)
        //1.通过类名.class获取
        Class c1 = Student.class;
        System.out.println(c1);
        //2.通过对象.getClass()获取
        Student s = new Student();
        Class c2 = s.getClass();
        //3.通过Class.forName()获取
        Class c3 = null;
        try {
            c3 = Class.forName("com.luo.demo2reflection.Student");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c2);//ture
        System.out.println(c1 == c3);//地址相同，指向同一个类对象

    }
}
