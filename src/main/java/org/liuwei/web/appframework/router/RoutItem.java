package org.liuwei.web.appframework.router;


import org.liuwei.web.container.request.Request;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2017/1/31.
 */
public class RoutItem {
    private Method method;
    private Request.HttpMethod httpMethod;
    private List<Integer> parameterPositions;

    public RoutItem(Method method, Request.HttpMethod httpMethod, List<Integer> parameterPositions) {
        this.parameterPositions = parameterPositions;
        this.method = method;
        this.httpMethod = httpMethod;
    }

    public Method getMethod() {
        return method;
    }

    public Request.HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public List<Integer> getParameterPositions() {
        return parameterPositions;
    }

    public Object[] generateParameters(String path){
        List<String> parameters = new ArrayList<>();
        String[] slashs = path.split("/");
        parameterPositions.forEach(p->{
            parameters.add(slashs[p]);
        });
        return parameters.toArray();
    }
}
