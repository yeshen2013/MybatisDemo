package com.lyyexample.MyAnnotation;

import java.lang.annotation.*;

/**
 * Created by liuyangyang on 2019/3/3.
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
}
