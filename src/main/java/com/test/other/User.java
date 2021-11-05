package com.test.other;

import java.io.Serializable;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-10-20 09:33
 */
public class User implements Serializable {
    private static final long serialversionuID = 123456L;
    private transient int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}