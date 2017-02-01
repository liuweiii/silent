package org.liuwei.web.appframework.router;

import org.liuwei.web.appframework.notation.path;
import org.liuwei.web.container.request.Request;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by apple on 2017/2/1.
 */
public class Router {
    private Map<PathPattern, RoutItem> routItems;

    public Router(){
        routItems = new HashMap<>();
    }

    public RoutItem get(String pathPattern) {
        return get(new PathPattern(pathPattern));
    }

    public RoutItem get(PathPattern pathPattern){
        return routItems.get(pathPattern);
    }

    public void put(String pathPattern, RoutItem routItem) {
        put(new PathPattern(pathPattern), routItem);
    }

    public void put(PathPattern pathPattern, RoutItem routItem){
        this.routItems.put(pathPattern, routItem);
    }

    public void put(path path, Method method){
        Request.HttpMethod httpMethod = path.httpMethod();
        String value = path.value();
        List<Integer> parameterPositions = new ArrayList<>();

        StringBuilder pathPatternString = new StringBuilder("");
        List<String> slashs = Arrays.asList(value.split("/"));
        for(Integer i = 1;i < slashs.size();i++){
            String slash = slashs.get(i);
            if(slash.startsWith("{") && slash.endsWith("}")){
                slash = "[^/]+";
                parameterPositions.add(i);
            }
            pathPatternString.append("/").append(slash);
        }
        PathPattern pathPattern = new PathPattern(pathPatternString.toString());
        RoutItem routItem = new RoutItem(method, httpMethod, parameterPositions);
        put(pathPattern, routItem);
    }
}
