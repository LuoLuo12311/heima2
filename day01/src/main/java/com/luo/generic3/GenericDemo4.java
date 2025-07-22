package com.luo.generic3;
//泛型方法，泛型变量有由自己定义，与泛型类中的普通方法不同
public class GenericDemo4 {
    public static void main(String[] args) {
        //目标：理解泛型方法搞清楚作用
        //打印任意数组的内容
        printArray(new Integer[]{1,2,3,4,5});
        System.out.println("===================");
        printArray(new String[]{"hello","world","java"});
        System.out.println("===================");
        printArray(new Double[]{1.1,2.2,3.3,4.4});
    }
    //泛型方法，一个方法能接受任意类型的数组
    public static <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    //泛型方法，一个方法能返回任意类型的数据,泛型变量做返回值，避免强转
    public static <T> T getMax(T[] arr) {

        T max = arr[0];

        return max;
    }
}
