package com.test.reflact;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: EnclosingClassTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/6/26 11:04
 * @Version: 1.0
 */
public class EnclosingClassTest {

    // constructor
    public EnclosingClassTest() {
        // class Outer as inner class for class ClassDemo

        // outer class show() function
        Outer o = new Outer();
        o.show();

        System.out.println(" DeclaringClasses ..." + JSON.toJSONString(getClass().getDeclaredClasses()));
    }

    class Outer {

        public void show() {
            // inner class of Class Outer

            System.out.print(getClass().getName() + " inner in...");
            System.out.print(getClass().getEnclosingClass());
            System.out.println(" DeclaringClass ..." + getClass().getDeclaringClass());
            System.out.println(" DeclaringClasses ..." + JSON.toJSONString(getClass().getDeclaredClasses()));
            // inner class show() function
            Inner i = new Inner();
            i.show();
        }

        class Inner {
            public void show() {
                System.out.print(getClass().getName() + " inner in...");
                System.out.print(getClass().getEnclosingClass());
                System.out.println(" DeclaringClass ..." + getClass().getDeclaringClass());
                System.out.println(" DeclaringClasses ..." + JSON.toJSONString(getClass().getDeclaredClasses()));
            }
        }
    }


    public static void main(String[] args) {
        // EnclosingClassTest cls = new EnclosingClassTest();
        int[] array = new int[5];
        array[-1] = -1;
        System.out.println(JSON.toJSONString(array));
    }


}
