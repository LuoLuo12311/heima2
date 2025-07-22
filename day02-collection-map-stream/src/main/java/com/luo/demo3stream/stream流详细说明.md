在 Java 开发中，`Stream` 流是 Java 8 引入的一个非常强大的功能，它提供了一种 **函数式编程** 风格的集合操作方式，用于处理集合数据，简洁且高效。

---

## 🧠 一、什么是 Stream 流？

* `Stream` 是对集合（如 `List`、`Set`）等数据源的元素进行\*\*一系列聚合操作（如过滤、排序、映射等）\*\*的高级迭代器。
* 和 I/O 中的流不同，它不会存储数据，只是按需计算。
* 通常由集合创建，通过链式操作构建处理逻辑，最后通过终止操作触发执行。

---

## ✨ 二、Stream 流的语法结构

```java
collection.stream()       // 获取流
    .filter(...)          // 中间操作1：过滤
    .map(...)             // 中间操作2：映射
    .sorted(...)          // 中间操作3：排序
    .collect(...)         // 终止操作：收集结果
```

---

## 🛠 三、常用方法分类

### 1. 获取流

```java
list.stream();            // 顺序流
list.parallelStream();    // 并行流（多线程）
```

### 2. 中间操作（懒执行）

| 方法                                | 说明      |
| --------------------------------- | ------- |
| `filter(Predicate)`               | 条件过滤    |
| `map(Function)`                   | 元素映射转换  |
| `flatMap(Function)`               | 多个流扁平化  |
| `limit(n)`                        | 截取前 n 个 |
| `skip(n)`                         | 跳过前 n 个 |
| `sorted()` / `sorted(Comparator)` | 排序      |
| `distinct()`                      | 去重      |

### 3. 终止操作（触发执行）

| 方法                                      | 说明     |
| --------------------------------------- | ------ |
| `collect(Collectors.toList())`          | 收集成集合  |
| `forEach(Consumer)`                     | 遍历     |
| `count()`                               | 计数     |
| `max()/min()`                           | 最大/最小值 |
| `reduce()`                              | 归约     |
| `anyMatch()`、`allMatch()`、`noneMatch()` | 匹配测试   |

---

## 📌 四、使用场景

| 场景    | 描述                           |
| ----- | ---------------------------- |
| 数据筛选  | 从集合中过滤符合条件的对象                |
| 数据转换  | 将某种类型转为另一种类型（如对象转字段）         |
| 聚合操作  | 求和、计数、分组等                    |
| 多条件排序 | 多字段组合排序                      |
| 分组统计  | 使用 `Collectors.groupingBy()` |
| 并发处理  | 使用 `parallelStream()` 加速处理   |

---

## 💡 五、Stream 特点总结

| 特性       | 描述                |
| -------- | ----------------- |
| **声明式**  | 用链式函数表达操作，而非显式迭代  |
| **惰性求值** | 中间操作不会立即执行，直到终止操作 |
| **不可变性** | 不修改原始集合，只生成新的结果   |
| **可并行**  | 支持并行流处理           |
| **可读性强** | 代码简洁、逻辑清晰         |

---

## 🧪 六、综合案例（学生分组 + 排序 + 汇总）

### 🌟 需求：

对一个学生列表，执行以下操作：

1. 按年级分组。
2. 每个年级内按成绩降序排序。
3. 筛选成绩大于 60 分的学生。
4. 汇总每个年级的平均成绩。

### ✅ 示例代码：

```java
import java.util.*;
import java.util.stream.*;
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

public class StreamDemo {
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
```

---

## 📚 七、进阶建议

* 结合 `Optional`、`Map` 使用流构造更加复杂的数据处理逻辑。
* 结合 `parallelStream()` 注意线程安全，尤其是共享变量。
* 常搭配 `Collectors` 工具类一起用，如：`groupingBy`、`partitioningBy`、`joining`、`reducing`。

---

如需我为你整理成 `.md` 格式或为你项目写一个更复杂的业务处理例子（比如电商订单聚合、用户分群分析等），也可以继续告诉我！
