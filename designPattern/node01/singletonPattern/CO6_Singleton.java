package com.liuxy.codeReview.com.lxy.designPattern.node01.singletonPattern;

/**
 * 这是单例模式的最佳实践，它实现简单，并且在面对复杂的序列化或者反射攻击的时候，能够防止实例化多次。
 */
enum Test {
    UNIQUEINSTANCE;
}

public class CO6_Singleton{
    public static void main(String[] args) {
        Test uniqueinstance01 = Test.UNIQUEINSTANCE;
        Test uniqueinstance02 = Test.UNIQUEINSTANCE;
        System.out.println(uniqueinstance01 == uniqueinstance02);
    }
}
