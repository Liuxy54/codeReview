package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 懒汉式（线程不安全）
 * 以下实现中，私有静态变量uniqueInstance被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化uniqueInstance，从而节约资源
 */
public class CO1_Singleton {

    private static CO1_Singleton uniqueInstance;

    private CO1_Singleton(){}

    public static CO1_Singleton getUniqueInstance() {
        /**
         * 这里存在线程问题
         */
        if (uniqueInstance == null){
            uniqueInstance = new CO1_Singleton();
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        CO1_Singleton singleton01 = CO1_Singleton.getUniqueInstance();
        CO1_Singleton singleton02 = CO1_Singleton.getUniqueInstance();
        System.out.println(singleton01);
        System.out.println(singleton02);
        System.out.println(singleton01==singleton02);
    }
}
