package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 饿汉式
 */
public class CO7_Singleton {
    public static void main(String[] args) {
        Runtime runtime1 = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();
        System.out.println(runtime1.hashCode());
        System.out.println(runtime2.hashCode());
        System.out.println(runtime1 == runtime2);
    }
}
