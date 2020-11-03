package com.test.classload;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-08 20:12
 */
public class ClassLoadTest {

    @Test
    public void getClassLoad() {
        System.out.println(ClassLoadTest.class.getClassLoader().getClass().getName());
    }

    @Test
    public void forName() throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.test.classload.ClassLoadTest");
        System.out.println(c1 == ClassLoadTest.class);
    }

    @Test
    public void myLoader() throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    is.close();
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("com.bj58.d2020.d0708.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoadTest);
    }
}
