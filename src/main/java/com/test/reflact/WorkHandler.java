package com.test.reflact;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: WorkHandler
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/22 17:42
 * @Version: 1.0
 */
public class WorkHandler implements InvocationHandler {

    private Object obj;

    public WorkHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 动态代理...");
        System.out.println(proxy.getClass().getName());
        System.out.println(this.obj.getClass().getName());
        if (method.getName().equals("work")) {
            method.invoke(this.obj, args);
            System.out.println("after 动态代理...");
            return proxy;
        } else {
            System.out.println("after 动态代理...");
            return method.invoke(this.obj, args);
        }
    }

}
