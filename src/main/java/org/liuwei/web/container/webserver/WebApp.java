package org.liuwei.web.container.webserver;

import org.liuwei.web.container.request.Request;
import org.liuwei.web.container.response.Response;

/**
 * Created by apple on 2017/1/31.
 */
public interface WebApp {
    Response processRequest(Request request);
}
