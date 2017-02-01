package org.liuwei.web.appframework;

import org.liuwei.silent.controller.API;
import org.liuwei.web.appframework.router.RoutItem;
import org.liuwei.web.appframework.router.Router;
import org.liuwei.web.appframework.router.Scanner;
import org.liuwei.web.container.exception.ControllerNotFoundException;
import org.liuwei.web.container.exception.ControllerWithHttpMethodNotFoundException;
import org.liuwei.web.container.request.Request;
import org.liuwei.web.container.response.HttpStatusCode;
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

        try {
            RoutItem routItem = router.get(request.path(), request.httpMethod());
            Object[] args = routItem.generateParameters(request.path());
            return (Response) routItem.getMethod().invoke(api, args);
        } catch (IllegalAccessException e) {
            LOGGER.warning("IllegalAccessException :"+e.getMessage());
        } catch (InvocationTargetException e) {
            LOGGER.warning("InvocationTargetException :"+e.getMessage());
        } catch (ControllerWithHttpMethodNotFoundException e){
            LOGGER.warning("ControllerWithHttpMethodNotFoundException :"+e.getMessage());
            return new Response(HttpStatusCode.METHOD_NOT_ALLOWED, e.getMessage());
        }catch(ControllerNotFoundException e){
            LOGGER.warning("ControllerNotFoundException :"+e.getMessage());
            return new Response(HttpStatusCode.NOT_FOUND, e.getMessage());
        }catch (Exception e){
            LOGGER.warning("Exception :"+e.getMessage());
        }
        return new Response(HttpStatusCode.INTERNAL_SERVER_ERROR, "WebApp Exception[Internal Server Error]!");
    }
}
