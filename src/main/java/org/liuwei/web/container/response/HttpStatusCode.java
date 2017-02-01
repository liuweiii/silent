package org.liuwei.web.container.response;

/**
 * Created by apple on 2017/2/1.
 */
public enum HttpStatusCode {
    OK("HTTP/1.1 200 OK"),
    NOT_FOUND("HTTP/1.1 404 Not Found"),
    METHOD_NOT_ALLOWED("HTTP/1.1 405 Method Not Allowed"),
    INTERNAL_SERVER_ERROR("HTTP/1.1 500 Internal Server Error");

    private String code;
    HttpStatusCode(String code){
        this.code = code;
    }

    @Override
    public String toString(){
        return code;
    }
}
