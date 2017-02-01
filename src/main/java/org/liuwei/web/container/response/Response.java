package org.liuwei.web.container.response;

/**
 * Created by apple on 2017/1/27.
 */
public class Response {

    private String content;
    private HttpStatusCode statusCode;

    public Response(HttpStatusCode statusCode, String content){
        this.statusCode = statusCode;
        this.content = content;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public String getContent(){
        return content;
    }
}
