package javasenior.Reflection.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 动态代理的举例
 * @Author hliu
 * @Date 2023/1/22 15:42
 * @Version 1.0
 */

interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eating" + food);
    }
}
//AOP:面向切面编程
class HumanUtil {
    public void method1() {
        System.out.println("*****通用方法1*****");
    }

    public void method2() {
        System.out.println("*****通用方法2*****");
    }
}

/*
* 要实现动态代理需要解决的问题？
* 1. 如何根据加载到内存中的被代理类，动态创建一个代理类及其对象
* 2. 如何通过代理类的对象动态地调用被代理类中的同名方法
*
* */
class ProxyFactory {
    //调用此方法，返回一个代理类的对象，解决问题1
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;//被代理类的对象

    public void bind(Object object) {
        this.object = object;
    }

    //当我们通过代理类的对象，调用方法a时, 就会自动调用如下的方法：invoke
    //将被代理类需要执行的方法a声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();

        //method:代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //object：被代理类的返回值
        Object invoke = method.invoke(object, args);

        humanUtil.method2();

        //上述方法的返回值
        return invoke;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();

        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //调用的是被代理的同名方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川火锅");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyInstance1.produceCloth();
    }

}
