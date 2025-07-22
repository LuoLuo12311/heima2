package com.luo.demo1hashset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher  implements Comparable{
    private String name;
    private int age;
    private double score;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}'+"\n";
    }

    @Override
    //1.让对象类实现Comparable接口，并重写compareTo方法制定比较规则
    //t2.compareTo(t1)
    //t2==this    比较者
    //t1==o       被比较者
    //java中规定，返回值大于0，则t2比t1大
    //java中规定，返回值小于0，则t2比t1小

    public int compareTo(Object o) {

        return this.getAge() - ((Teacher)o).getAge();
        //如果想保留两个比较值相等的不同对象，就不要，return 0
    }
}
