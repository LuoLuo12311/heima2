import com.luo.demo2reflection.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ReflectionDemo21 {
    @Test
    public void getClassM(){
        //目标：获取类中的信息，并对其进行操作
        //第一步：获取class对象，代表拿到类

        Class c1 = Student.class;
        String name = c1.getName();//获取类名本身
        System.out.println(name);//com.luo.demo2reflection.Student//类的全类名
        String simpleName = c1.getSimpleName();
        System.out.println(simpleName);// Student//类的简单名



    }
    @Test//2.获取类的构造器对象
    public void getConstructorM(){
        //目标：获取类的构造器对象并对其进行操作
        Class c1 = Student.class;

        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor c:declaredConstructors) {//遍历构造器对象
            System.out.println(c);
        }


    }
}
