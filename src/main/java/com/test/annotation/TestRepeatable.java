package com.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @ClassName: TestRepeatable
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/1/8 17:17
 * @Version: 1.0
 */
public class TestRepeatable {
    @RepeaDemo(id = "1001", name = "荔枝")
    @RepeaDemo(id = "1003", name = "沃柑")
    private String fruit1;

    @RepeaDemo(id = "1002", name = "葡萄")
    private String fruit2;

    public static void demo1() {
        Class<?> a = TestRepeatable.class;
        Field[] fruits = a.getDeclaredFields();
        Arrays.stream(fruits).forEach(f -> {
            if (f.isAnnotationPresent(RepeaDemo.class)) {
                RepeaDemo anno = f.getAnnotation(RepeaDemo.class);
                String id = anno.id();
                String name = anno.name();
                System.out.printf("水果id:%s,水果名称:%s%n", id, name);
            }
        });
    }


    public static void demo2() {
        Class<?> a = TestRepeatable.class;
        Field[] fruits = a.getDeclaredFields();
        Arrays.stream(fruits).forEach(f -> {
            if (f.isAnnotationPresent(RepeaDemos.class)) {
                RepeaDemos anno = f.getAnnotation(RepeaDemos.class);
                RepeaDemo[] res = anno.value();
                Arrays.stream(res).forEach(r -> System.out.printf("水果id:%s,水果名称:%s%n", r.id(), r.name()));
            }
            if (f.isAnnotationPresent(RepeaDemo.class)) {
                RepeaDemo anno = f.getAnnotation(RepeaDemo.class);
                String id = anno.id();
                String name = anno.name();
                System.out.printf("水果id:%s,水果名称:%s%n", id, name);
            }
        });
    }

    public static void demo3() {
        Class<?> a = TestRepeatable.class;
        Field[] fruits = a.getDeclaredFields();
        Arrays.stream(fruits).forEach(f -> {
            for (Annotation annotation : f.getDeclaredAnnotations()) {
                System.out.println(annotation.annotationType().getName());
            }
        });
    }

    public static void main(String[] args) {
        demo3();
    }
}
