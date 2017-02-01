package org.liuwei.web.appframework.router;

import org.liuwei.web.appframework.notation.path;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/31.
 */
public class Scanner {
    private List<String> controllers;
    private static final Logger LOGGER = Logger.getLogger(Scanner.class.getName());

    public Scanner(List<String> controllers) {
        this.controllers = controllers;
    }

    public Router scan() {
        Router router = new Router();
        controllers.forEach(controller -> {
            try {
                List<Method> methods = Arrays.asList(Class.forName(controller).getMethods());
                methods.forEach(method -> {
                    List<Annotation> annotations = Arrays.asList(method.getDeclaredAnnotations());
                    annotations.forEach(annotation -> {
                        if (annotation instanceof path) {
                            router.put((path)annotation, method);
                        }
                    });
                });
            } catch (ClassNotFoundException e) {
                LOGGER.warning("Class " + controller + " Not Found:" + e.getMessage());
            }
        });
        return router;
    }
}
