package com.example.demosingleton;

/**
 * 思想:

　　相比于懒汉以及饿汉模式，静态内部类模式（一般也被称为 Holder）是许多人推荐的一种单例的实现方式，因为相比懒汉模式，它用更少的代码量达到了延迟加载的目的。

　　顾名思义，这种模式使用了一个私有的静态内部类，来存储外部类的单例，这种静态内部类，一般称为 Holder。

　　而利用静态内部类的特性，外部类的 getinstance() 方法，可以直接指向 Holder 持有的对象。

    a.反射能否打破单例？

　　首先，对外部类的私有构造器中加入 instance==null 的判断，防止反射入侵外部类。

　　其次，静态内部类保证了从外部很难获取 SingletonHolder 的 Class 对象，从而保证了内部类不会被反射。

    b.多线程能否打破单例？

　　Holder 模式借用了饿汉模式的优势，就是在加载类（内部类）的同时对 instance 对象进行初始化。

　　由于自始至终类只会加载一次，所以即使在多线程的情况下，也能够保持单例的性质。

    c.优势？劣势？

　　优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。

　　劣势：需要多加载一个类；相比于懒汉模式，Holder 创建的单例，只能通过 JVM 去控制器生命周期，不能手动 destroy。
 * @author andysuning
 *
 */
public class StaticInnerSingleton {	//懒汉式（静态内部类）：同事解决了安全问题与性能问题
	
	//1.先声明一个私有的静态内部类
	private static class LazyHandle {
		private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
	}
	
	//2.将默认构造器私有化：外部无法new 出对象，只能通过 getInstance 方法获取实例
	private StaticInnerSingleton() {}
	
	//3.提供静态方法获取实例
	public  static final StaticInnerSingleton getInstance() {		
		return LazyHandle.INSTANCE;
	}

}
