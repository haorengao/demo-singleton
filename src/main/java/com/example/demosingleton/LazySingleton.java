package com.example.demosingleton;

/**
 * 思想：
　　相比于饿汉模式，懒汉模式实际中的应用更多，因为在系统中，“被用到时再初始化”是更佳的解决方案。
　　设计思想与饿汉模式类似，同样是持有一个自身的引用，只是将 new 的动作延迟到 getinstance() 方法中执行。

    a.为什么是 synchronized 方法？
　　		因为是延迟加载，考虑到多线程情况，需要对方法同步。
    b.同步方法带来的性能问题？
　　		可以使用 synchronized 代码块 + Double-check Locking + volatile 关键字，对 LazySingleton 进行深一步优化，详情见：第003弹：懒汉型单例模式的演变
    c.优势？劣势？
　　		优势：延迟加载。
　　		劣势：不能完全屏蔽反射入侵，而且代码较为繁琐。
 * @author andysuning
 *
 */
public final class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}