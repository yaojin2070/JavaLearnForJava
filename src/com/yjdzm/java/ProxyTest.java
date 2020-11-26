package com.yjdzm.java;

import com.sun.org.apache.xerces.internal.dom.PSVIDocumentImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YaoJin
 * @create 2020-11-26 19:53
 * @description
 */

interface Human {
  String sad ();
  void dream(String dream);
}

// 被代理类
class Man implements Human {
  // 重写抽象方法
  @Override
  public String sad() {
    return "我很不开心, 因为我生病了!";
  }

  @Override
  public void dream(String dream) {
    System.out.println("我希望" + dream);
  }
}

// 创建代理工厂
class ProxyFactory {
  public static Object getProxyInstance(Object obj) {
    MyInvocationHandler handler = new MyInvocationHandler();

    handler.bind(obj);
    // 动态获取类加载器以及接口
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
  }
}

class MyInvocationHandler implements InvocationHandler{
  private Object obj;

  // 绑定被代理类
  public void bind(Object obj){
    this.obj = obj;
  }

  //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
  //将被代理类要执行的方法a的功能就声明在invoke()中
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
    //obj:被代理类的对象
    Object returnValue = method.invoke(obj,args);
    //上述方法的返回值就作为当前类中的invoke()的返回值。
    return returnValue;

  }
}

public class ProxyTest {
  public static void main(String[] args) {
    Man yaoJin = new Man();
    // proxyInstance:代理类的对象
    Human proxyInstance = (Human) ProxyFactory.getProxyInstance(yaoJin);
    //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
    String info = proxyInstance.sad();
    System.out.println(info);
    proxyInstance.dream("病赶紧好");
  }
}
