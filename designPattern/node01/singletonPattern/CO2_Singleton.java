package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 饿汉式-线程安全
 * 线程不安全问题主要是由于uniqueinstance被多次实例化，采取直接实例化unique instance的方式就不会产生线程不安全问题。但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处
 */
public class CO2_Singleton {
    private static CO2_Singleton uniqueInstance = new CO2_Singleton();

    private CO2_Singleton(){}

    public static CO2_Singleton getUniqueInstance() {
        return uniqueInstance;
    }

    public static void main(String[] args) {
        CO2_Singleton singleton01 = CO2_Singleton.getUniqueInstance();
        CO2_Singleton singleton02 = CO2_Singleton.getUniqueInstance();
        System.out.println(singleton01);
        System.out.println(singleton02);
        System.out.println(singleton01==singleton02);
    }
}
