package com.test.object;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-10-15 10:34
 */
public class ObjectTest {

    @Test
    public void copy() throws CloneNotSupportedException {
        Person p1 = new Person();
        p1.age = 12;
        p1.name = "张三";
        Person p2 = p1.clone();
        System.out.println(p1 == p2);
        System.out.println("p2.name:" + p2.name);
        p2.name = "李四";
        System.out.println("p1.name:" + p1.name);
        System.out.println("p2.name:" + p2.name);
    }
}
