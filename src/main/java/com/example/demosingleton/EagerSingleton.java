package com.example.demosingleton;
/**
 * 思想： 
　　饿汉模式是最常提及的2种单例模式之一，其核心思想，是类持有一个自身的 instance 属性，并且在申明的同时立即初始化。
　　同时，类将自身的构造器权限设为 private，防止外部代码创建对象，对外只提供一个静态的 getInstance() 方法，作为获取单例的唯一入口。

  a.为什么在私有构造器中加入对 instance 属性的空校验？ 
　　为了阻止反射的入侵，从而打破单例。 
  b.多线程的情况下会不会打破单例？
　　不会，因为 EagerSingleton 是在加载类的同时进行对象的创建，所以即使在多线程并发的情况下，仍然可以保证单例。 
  c.优势？劣势？
　　在加载类的同时创建单例对象，如果这个对象不是立刻需要使用的，会额外增加内存的消耗。

 * @author andysuning
 *
 */
public final class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }

    public static final EagerSingleton getInstance() {
        return instance;
    }

}