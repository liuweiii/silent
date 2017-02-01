package org.liuwei.web.appframework;

import org.liuwei.web.appframework.router.Scanner;
import org.liuwei.web.container.request.Request;
import org.liuwei.web.container.response.Response;
import org.liuwei.web.container.webserver.WebApp;

import java.util.Arrays;

/**
 * Created by apple on 2017/1/31.
 */
public class Silent implements WebApp {
    public Silent(){
        Scanner scanner = new Scanner(Arrays.asList("org.liuwei.silent.controller.API"));
        scanner.scan();
    }

    @Override
    public Response processRequest(Request request) {
        return new Response("HTTP/1.1 200 OK","lijing...");
    }
}
