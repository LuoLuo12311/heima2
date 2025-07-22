package com.luo.demo3stream;
import java.util.*;

import static java.util.stream.Collectors.*;

class Student {
    String name;
    int grade;
    double score;

    Student(String name, int grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public String toString() {
        return name + " | 年级: " + grade + " | 分数: " + score;
    }

    public int getGrade() { return grade; }
    public double getScore() { return score; }
    public String getName() { return name; }
}

public class StreamDemo1 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("张三", 1, 85.0),
                new Student("李四", 2, 58.0),
                new Student("王五", 1, 91.0),
                new Student("赵六", 2, 75.0),
                new Student("孙七", 1, 60.0),
                new Student("周八", 2, 98.0)
        );

        // 1. 过滤成绩 > 60
        List<Student> passed = students.stream()
                .filter(s -> s.getScore() > 60)
                .collect(toList());

        System.out.println("及格的学生：");
        passed.forEach(System.out::println);

        // 2. 按年级分组，并在组内排序
        Map<Integer, List<Student>> grouped = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        collectingAndThen(
                                toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                                        .collect(toList())
                        )
                ));

        System.out.println("\n按年级分组并排序：");
        grouped.forEach((grade, list) -> {
            System.out.println("年级: " + grade);
            list.forEach(System.out::println);
        });

        // 3. 每个年级的平均成绩
        Map<Integer, Double> avgScores = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        averagingDouble(Student::getScore)
                ));

        System.out.println("\n年级平均成绩：");
        avgScores.forEach((grade, avg) -> {
            System.out.println("年级 " + grade + " 的平均成绩为：" + avg);
        });
    }
}

