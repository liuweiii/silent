package org.liuwei.silent.controller;

import org.liuwei.web.appframework.notation.path;
import org.liuwei.web.container.response.HttpStatusCode;
import org.liuwei.web.container.response.Response;

/**
 * Created by apple on 2017/1/31.
 */
public class API {
    @path("/silent/about")
    public Response about(){
        return new Response(HttpStatusCode.OK,"silent api v1.0");
    }

    @path("/a/{b}/c/{d}")
    public Response test(String b,String c){
        return new Response(HttpStatusCode.OK,"silent: b="+b+",c="+c);
    }

}
