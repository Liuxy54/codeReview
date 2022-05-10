package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 静态内部类实现
 *
 * 当Singleton类加载时，静态内部类SingletonHolder没有被加载进内存。只有当调用getUniqueInstance()方法从而触发SingletonHolder.INSTANCE时SingletonHolder才会被加载，此时初始化INSTANCE为例。
 * 这种方式不仅具有延迟初始化的好处，而且由虚拟机提供了对线程安全的支持。
 */
public class CO5_Singleton {
    private volatile static CO5_Singleton uniqueInstance;

    private CO5_Singleton() {
    }

    private static class SingletonHolder {
        private static final CO5_Singleton INSTANCE = new CO5_Singleton();
    }

    public static CO5_Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        CO5_Singleton singleton01 = CO5_Singleton.getUniqueInstance();
        CO5_Singleton singleton02 = CO5_Singleton.getUniqueInstance();
        System.out.println(singleton01);
        System.out.println(singleton02);
        System.out.println(singleton01==singleton02);
    }

    /**
     * uniqueInstance 采用volatile 关键字修饰也是很有必要的。uniqueInstance = newSingleton(); 这段代码其实是分为三步执行。
     * 分配内存空间
     * 初始化对象
     * 奖uniqueinstance 指向分配的内存地址
     *
     * 但是由于jvm具有指令重拍的特性，有可能执行顺序1>3>2,这在单线程的情况下自然是没有问题。但如果是多线程下，有可能获得是一个还没有被初始化的实例，以至于程序出错。
     *
     * 使用volatile 可以禁止jvm的指令重排，保证在多线程环境下也能正常运行。
     */
}
