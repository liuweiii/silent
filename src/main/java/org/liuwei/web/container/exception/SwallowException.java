package org.liuwei.web.container.exception;


/**
 * Created by apple on 2017/1/31.
 */
public class SwallowException extends RuntimeException {
    public SwallowException(Exception e){
        super(e);
    }
}
