package org.liuwei.web.container.webserver;

import com.google.common.base.Strings;
import org.liuwei.web.container.exception.SwallowException;
import org.liuwei.web.container.request.Request;
import org.liuwei.web.container.response.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/27.
 */
public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(8011);
        LOGGER.info("started!");
        while (!pool.isShutdown()) {
            final Socket connection = socket.accept();
            pool.execute(new Runnable() {
                public void run() {
                    handleRequest(connection);
                }
            });
        }
    }

    private void handleRequest(Socket connection) {
        Request request = readRequest(connection);
        if (isShutdownRequest(request)) {
            stop();
        } else {
            Response response = dispatchRequest(request);
            sendResponse(response, connection);
        }
    }

    private void sendResponse(Response response, Socket connection) {
        try {
            PrintStream writer = new PrintStream(connection.getOutputStream());
            writer.println(response.getStatusCode());
            writer.println();//http protocol, response status should end with space;
            writer.println(response.getContent());
            writer.close();
        } catch (IOException e) {
            LOGGER.warning("io exception when write socket:" + e.getMessage());
            throw new SwallowException(e);
        }
    }

    private Request readRequest(Socket connection) {
        InputStream in;
        StringBuilder header;
//        StringBuilder body;
        String buffer;
        try {
            in = connection.getInputStream();

            header = new StringBuilder();
//            body = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //read header
            while(!Strings.isNullOrEmpty((buffer = br.readLine()))){
                header.append(buffer);
                header.append("\n");
            }

            //read body
//            while ((buffer = br.readLine()) != null) {
//                body.append(buffer);
//            }

            return new Request(header.toString(), null);
        } catch (IOException e) {
            LOGGER.warning("io exception when read socket:" + e.getMessage());
            throw new SwallowException(e);
        }
    }

//    private Request readRequest(Socket connection) {
//        InputStream in;
//        StringBuilder sb;
//        try {
//            in = connection.getInputStream();
//            sb = new StringBuilder();
//            char c;
//            while ((c = (char)in.read()) >0) {
//                if (c >= 255) break;
//                sb.append(c);
//            }
//            return new Request(sb.toString());
//        }catch (IOException e){
//            LOGGER.warning("io exception when read socket:" + e.getMessage());
//            throw new SwallowException(e);
//        }
//    }

    private Response dispatchRequest(Request request) {
        return new Response("HTTP/1.1 200 OK","abc123...");
    }

    private boolean isShutdownRequest(Request request) {
        return false;
    }

    public void stop() {
        pool.shutdown();
    }
}
