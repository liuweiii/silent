package org.liuwei.web.container.exception;

/**
 * Created by apple on 2017/2/1.
 */
public class ControllerNotFoundException extends RuntimeException {
    public ControllerNotFoundException(String message){
        super(message);
    }
}
