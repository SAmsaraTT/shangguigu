package javasenior.java8.Optional;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Optional;

/**
 * Optional:为了在程序中避免出现空指针异常而创建的。
 *
 * @Author hliu
 * @Date 2023/1/28 13:46
 * @Version 1.0
 */
public class OptionalTest {
  /*
  * Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
  * Optional.empty() : 创建一个空的 Optional 实例
  * Optional.ofNullable(T t)：t可以为null
  * */
    @Test
    public void test1() {
        Girl girl = new Girl();
        //of(T t)保证t非空
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);

        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl girl2 = girl1.orElse(new Girl("赵丽颖"));
        System.out.println(girl2);
    }


    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化后
    public String getGirlName1(Boy boy) {
       if (boy == null) {
           return null;
       }

        Girl girl = boy.getGirl();
       if (girl == null) {
           return  null;
       }

       return girl.getName();
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类优化
    public String getGirlName2(Boy boy) {
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy boy2 = boy1.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy2.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("古力娜扎"));

        return girl2.getName();
    }

    @Test
    public void test5() {
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("程潇"));
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);
    }
}
