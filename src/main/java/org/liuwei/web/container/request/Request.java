package org.liuwei.web.container.request;

import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/27.
 */
public class Request {
    private static final Logger LOGGER = Logger.getLogger(Request.class.getName());

    public static class Header{

    }

    public static class Body{

    }

    public Request(String stringHeader, String stringBody){
        LOGGER.info("[request] "+stringHeader);
    }
}
