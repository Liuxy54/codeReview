package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 双重校验锁-线程安全
 *
 * uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那部分的代码进行，只有当uniqueInstance 没有被实例化，才需要进行加锁。
 * 双重校验锁先判断unique instance是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁。
 */
public class CO4_Singleton {
    private volatile static CO4_Singleton uniqueInstance ;

    private CO4_Singleton(){}

    public static  CO4_Singleton getUniqueInstance() {
        if (uniqueInstance == null){
            synchronized (CO4_Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new CO4_Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        CO4_Singleton singleton01 = CO4_Singleton.getUniqueInstance();
        CO4_Singleton singleton02 = CO4_Singleton.getUniqueInstance();
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
