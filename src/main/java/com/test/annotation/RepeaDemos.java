package com.test.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: RepeaDemos
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/1/8 17:15
 * @Version: 1.0
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeaDemos {
    RepeaDemo[] value();
}
