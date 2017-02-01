package org.liuwei.web.appframework.router;

import sun.rmi.runtime.Log;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/31.
 */
public class Scanner {
    private List<String> controllers;
    private static final Logger LOGGER = Logger.getLogger(Scanner.class.getName());

    public Scanner(List<String> controllers){
        this.controllers = controllers;
    }

    public void scan(){
        controllers.forEach(controller->{
            try {
                List<Method> methods = Arrays.asList(Class.forName(controller).getMethods());
                methods.forEach(method -> {

                });
            } catch (ClassNotFoundException e) {
                LOGGER.warning("Class "+controller+" Not Found:"+e.getMessage());
            }
        });
    }
}
