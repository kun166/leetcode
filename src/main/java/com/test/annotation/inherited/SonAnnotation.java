package com.test.annotation.inherited;

import java.lang.annotation.*;


@Inherited
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SonAnnotation {
}
