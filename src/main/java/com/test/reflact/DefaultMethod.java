package com.test.reflact;

/**
 * @ClassName: DefaultMethod
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/4/1 15:30
 * @Version: 1.0
 */
public interface DefaultMethod {

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }

    static void staticMethod() {
        System.out.println("staticMethod");
    }

    void abstractMethod();
}
