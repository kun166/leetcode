package com.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 格式是固定的,方法属性名称必须是value,
 * 且方法返回类型必须是{@link Repeatable}标注的那个注解的数组
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Persons {
    Person[] value();
}
