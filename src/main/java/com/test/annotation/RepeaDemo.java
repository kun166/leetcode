package com.test.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: RepeaDemo
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/1/8 17:14
 * @Version: 1.0
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(RepeaDemos.class)
public @interface RepeaDemo {
    String id();

    String name();
}
