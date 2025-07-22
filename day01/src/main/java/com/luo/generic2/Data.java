package com.luo.generic2;
//自定义泛型接口
public interface Data <T>{
    void add(T t);
    void remove(T t);
     T get(int index);//返回值类型为T，根据index查找老师数据
}
