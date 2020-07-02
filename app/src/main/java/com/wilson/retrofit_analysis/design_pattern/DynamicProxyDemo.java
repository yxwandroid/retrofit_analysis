package com.wilson.retrofit_analysis.design_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 代理模式最大的特点就是代理类和实际业务类实现同一个接口（或继承同一父类），代理对象持有一个实际对象的引用，
 * 外部调用时操作的是代理对象，而在代理对象的内部实现中又会去调用实际对象的操作
 *
 * 首先通过newProxyInstance方法获取代理类实例，
 * 而后我们便可以通过这个代理类实例调用代理类的方法，
 * 对代理类的方法的调用实际上都会调用中介类(调用处理器)的invoke方法，
 * 在invoke方法中我们调用委托类的相应方法，并且可以添加自己的处理逻辑。
 *  retrofit 的动态代理
 *  https://blog.csdn.net/yingpaixiaochuan/article/details/85232965
 *  https://cloud.tencent.com/developer/article/1430606
 *
 *
 *   retrofit为什么使用动态代理模式
 *      1,首先应用的接口请求有很多,通过动态代理模式,能为每个接口生成代理类,实现了我们的接口,不用关系具体的请求细节是什么,只需要我们传递接口给retrofit就行了,
 *
 *
 */
public class DynamicProxyDemo {
    public static void main(String[] arg) {

//        动态生成代理类

        //创建中介类实例
        DynamicProxy inter = new DynamicProxy(new Vendor());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获取代理类实例sell
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, inter));

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();

    }

}


interface Sell {
    void sell();

    void ad();
}

//委托类
class Vendor implements Sell {
    public void sell() {
        System.out.println("In sell method");
    }

    public void ad() {
        System.out.println("ad method");
    }
}

//中介类
class DynamicProxy implements InvocationHandler {
    //obj为委托类对象;
    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(obj, args);
        System.out.println("after");
        return result;
    }

}















