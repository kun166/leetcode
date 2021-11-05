package com.test.object;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-10-15 10:33
 */
public class Person implements Cloneable {

    public Integer age;

    public String name;

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
