package com.test.object;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-10-15 10:33
 */
public class Person implements Cloneable {

    protected Integer age;

    protected String name;

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
