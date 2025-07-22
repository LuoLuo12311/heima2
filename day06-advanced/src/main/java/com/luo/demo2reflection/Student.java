package com.luo.demo2reflection;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int age;
    public void show(){
        System.out.println("show()方法执行了");
    }
}
