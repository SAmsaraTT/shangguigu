package javasenior.Reflection.ProxyTest;
/*
* 静态代理
* */
interface ClothFactory{
    void produceCloth();
}
//代理类

class ProxyClothFactory implements ClothFactory {
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        clothFactory.produceCloth();

        System.out.println("代理工厂做一些后续收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("生产一批球鞋！");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nikeClothFactory = new NikeClothFactory();

        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}
