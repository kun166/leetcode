package com.test.annotation.inherited;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

/**
 * @ClassName: Son
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/1/10 16:37
 * @Version: 1.0
 */
@SonAnnotation
@Slf4j
public class Son extends Parent {

    public static void main(String[] args) {
        Annotation[] annotations = Son.class.getAnnotations();
        for (Annotation annotation : annotations) {
            log.info(annotation.annotationType().getName());
        }
//        log.info("DeclaredAnnotations:{}", JSON.toJSONString(Son.class.getDeclaredAnnotations()));
//        log.info("Annotations:{}", JSON.toJSONString(Son.class.getAnnotations()));

    }
}
