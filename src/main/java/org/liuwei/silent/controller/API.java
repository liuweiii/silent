package org.liuwei.silent.controller;

import org.liuwei.web.appframework.notation.path;
import org.liuwei.web.container.response.Response;

/**
 * Created by apple on 2017/1/31.
 */
public class API {
    @path("/silent/about")
    public Response about(){
        return new Response("200 OK","silent api v1.0");
    }
}
