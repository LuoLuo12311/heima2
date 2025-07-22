package com.luo.generic2;

public class GenericDemo3 {
    public static void main(String[] args) {

        //搞清泛型接口的基本作用
        //需求：需要对学生老师进行增删改查

        StudentData studentData = new StudentData();
        studentData.add(new Student());
        Student s1=studentData.get(0);

    }
}
