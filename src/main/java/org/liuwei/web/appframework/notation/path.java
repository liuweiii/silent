package org.liuwei.web.appframework.notation;

import org.liuwei.web.container.request.Request;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by apple on 2017/1/31.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface path{
    String value();
    Request.HttpMethod httpMethod() default Request.HttpMethod.GET;
}
