package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 懒汉式-线程安全
 *
 * 只需要对getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，从而避免了多次实例化uniqueInstance的问题。
 * 但是当一个线程进入该方法之后，其他试图进入该方法的线程都必须等待，因此性能上有一定的损耗。
 */
public class CO3_Singleton {
    private static CO3_Singleton uniqueInstance ;

    private CO3_Singleton(){}

    public static synchronized CO3_Singleton getUniqueInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new CO3_Singleton();
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        CO3_Singleton singleton01 = CO3_Singleton.getUniqueInstance();
        CO3_Singleton singleton02 = CO3_Singleton.getUniqueInstance();
        System.out.println(singleton01);
        System.out.println(singleton02);
        System.out.println(singleton01==singleton02);
    }
}
