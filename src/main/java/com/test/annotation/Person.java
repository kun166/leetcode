package com.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注意这个Persons
 * 如果一个注解被{@link Repeatable}注解注解了,则需要一个注解,
 * 例如本例的Persons
 * Persons格式是固定的。当获取被Person标注的类的注解时，会返回Persons注解
 */
@Repeatable(Persons.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Person {
    /**
     * 方法即属性,这是注解的特性
     *
     * @return
     */
    String role() default "";
}
