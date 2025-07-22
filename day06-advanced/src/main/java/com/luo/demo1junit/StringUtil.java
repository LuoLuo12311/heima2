package com.luo.demo1junit;
/**
 * 字符串工具类
 */
public class StringUtil {
    /**
     * 反转字符串
     */
    public static String reverse(String str)
    {
        String result = "";
        for(int i=str.length()-1;i>=0;i--)
        {
            result += str.charAt(i);
        }
        return result;
    }
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str)
    {
        return str==null||str.length()==0;
    }
    /**
     * 求字符串的最大索引
     */
    public static int indexOf(String str,char c){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c){
                return i;
            }
        }
        return -1;
    }
}
