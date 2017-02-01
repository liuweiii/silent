package org.liuwei.web.container.exception;

/**
 * Created by apple on 2017/2/1.
 */
public class ControllerWithHttpMethodNotFoundException extends RuntimeException {
    public ControllerWithHttpMethodNotFoundException(String message){
        super(message);
    }
}
