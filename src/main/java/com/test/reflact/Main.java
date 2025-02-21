package com.test.reflact;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: Main
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/4/1 15:32
 * @Version: 1.0
 */
public class Main {

    @Test
    public void main() {
        StaticMethod staticMethod = new StaticMethod();
        for (Method method : StaticMethod.class.getMethods()) {
            if ("staticMethod".equals(method.getName())) {
                System.out.println(method.getReturnType().getName());
            }
        }
    }

    @Test
    public void proxy() {
        People people = new Student();
        InvocationHandler handler = new WorkHandler(people);

        People proxy = (People) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        People p = proxy.work("写代码").work("开会").work("上课");

        System.out.println("打印返回的对象");
        System.out.println(p.getClass());

        String time = proxy.time();
        System.out.println(time);

        System.out.println(p == people);
    }


}
