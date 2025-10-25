package com.javapoc.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InactiveApi {
    String reason() default "This API is marked inactive and should not be used.";
}
