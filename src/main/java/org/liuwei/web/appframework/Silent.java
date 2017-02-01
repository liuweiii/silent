package org.liuwei.web.appframework;

import org.liuwei.silent.controller.API;
import org.liuwei.web.appframework.router.RoutItem;
import org.liuwei.web.appframework.router.Router;
import org.liuwei.web.appframework.router.Scanner;
import org.liuwei.web.container.request.Request;
import org.liuwei.web.container.response.Response;
import org.liuwei.web.container.webserver.WebApp;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/31.
 */
public class Silent implements WebApp {
    private static final Logger LOGGER = Logger.getLogger(Silent.class.getName());
    private static final API api = new API();
    private Router router;
    public Silent(){
        router = new Scanner(Arrays.asList("org.liuwei.silent.controller.API")).scan();
    }

    @Override
    public Response processRequest(Request request) {
        RoutItem routItem = router.get(request.path());

        try {
            Object[] args = routItem.generateParameters(request.path());
            return (Response) routItem.getMethod().invoke(api, args);
        } catch (IllegalAccessException e) {
            LOGGER.warning("IllegalAccessException :"+e.getMessage());
        } catch (InvocationTargetException e) {
            LOGGER.warning("InvocationTargetException :"+e.getMessage());
        } catch (Exception e){
            LOGGER.warning("Exception :"+e.getMessage());
        }
        return new Response("HTTP/1.1 500 Internal Server Error", "WebApp Exception[Internal Server Error]!");
    }
}
