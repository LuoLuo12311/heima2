package com.luo.generic;

// 泛型类
// E 表示元素范型变量一般使用E，T，K，V四个字母中来表示
public class MyArrayList< E> {

    private E[] array;
    private int index;
    public MyArrayList()
    {
        array = (E[]) new Object[10];
    }
    public void add(E e)
    {
        array[index++] = e;
    }
    public E get(int index)
    {
        return array[index];
    }
    public int size()
    {
        return index;
    }

}
