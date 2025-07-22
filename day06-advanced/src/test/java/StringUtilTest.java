import com.luo.demo1junit.StringUtil;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    //测试类使用junit单元测试框架，对业务类中的业务方法进行正确测试

    //测试方法：必须是公开的，无参数，无返回值
    //测试方法必须加上@Test注解（junit的核心步骤）
    @Test
    public void testReverse() {
        String str = "hello";
        //测试用例，既有非法测试样例，也有合法测试样例边界值测试
        String expected = "olleh";
        String actual = StringUtil.reverse(str);
        String reverse = StringUtil.reverse(str);
        System.out.println(reverse);
        System.out.println(expected.equals(actual));
    }
    @Test
    public void testIndexOf() {
        String str = "hello";
        int index = StringUtil.indexOf(str, 'l');
        System.out.println(index);
        System.out.println(StringUtil.indexOf(str,'a'));
        System.out.println(StringUtil.indexOf(str,'o'));
        System.out.println(StringUtil.indexOf(str,'h'));
        System.out.println(StringUtil.indexOf(str,'x'));
        System.out.println(StringUtil.indexOf(str,'l'));
        System.out.println(StringUtil.indexOf(str,' '));
        //测试还要做断言测试：断言结果与预期结果是否一致
        //断言java提供了一个断言方法，如果一致，则测试通过，不一致则测试失败
        Assert.assertEquals("断言失败",3,StringUtil.indexOf(str,'l'));


    }
}
