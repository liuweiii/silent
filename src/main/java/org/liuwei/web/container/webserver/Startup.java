package org.liuwei.web.container.webserver;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/31.
 */
public class Startup {
    private static final Logger LOGGER = Logger.getLogger(Startup.class.getName());

    public static void main(String[] args) {
        Server server = new Server();
        try {
            LOGGER.info("starting...");
            server.start();
        } catch (IOException e) {
            LOGGER.warning("startup failed:"+e.getMessage());
            server.stop();
            LOGGER.warning("stopped!");
        }
    }
}
