package org.liuwei.web.container.request;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by apple on 2017/1/27.
 */
public class Request {
    private static final Logger LOGGER = Logger.getLogger(Request.class.getName());

    public enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }
    public static class Header{
        private HttpMethod httpMethod;
        private String path;
        private String protocol;
        private String host;
        private String connection;
        private String cacheControl;
        private String accept;

        public Header(String stringHeader){
            List<String> headers = Arrays.asList(stringHeader.split("\n"));
            String[] firstLineHeader = headers.get(0).split(" ");
            this.httpMethod = HttpMethod.valueOf(firstLineHeader[0].toUpperCase());
            this.path = firstLineHeader[1];
            this.protocol = firstLineHeader[2];
            headers.forEach(header -> {
                if(header.toUpperCase().startsWith("HOST:")){
                    this.host = header.split(":")[1].trim();
                }else if(header.toUpperCase().startsWith("CONNECTION:")){
                    this.connection = header.split(":")[1].trim();
                }else if(header.toUpperCase().startsWith("CACHE-CONTROL:")){
                    this.cacheControl = header.split(":")[1].trim();
                }else if(header.toUpperCase().startsWith("ACCEPT:")){
                    this.accept = header.split(":")[1].trim();
                }
            });
        }
    }

    public static class Body{

    }

    public Request(String stringHeader, String stringBody){
        LOGGER.info("[request] "+stringHeader);
        this.header = new Header(stringHeader);
    }

    private Header header;

    public HttpMethod httpMethod(){
        return header.httpMethod;
    }

    public String path(){
        return header.path;
    }

    public String protocol(){
        return header.protocol;
    }

    public String host(){
        return header.host;
    }

    public String connection(){
        return header.connection;
    }

    public String cacheControl(){
        return header.cacheControl;
    }
}
