package org.liuwei.web.appframework.router;


import java.lang.reflect.Method;

/**
 * Created by apple on 2017/1/31.
 */
public class RoutItem {
    private Method method;
    private String keyPattern;
    public RoutItem(String keyPattern, Method method){
        this.keyPattern = keyPattern;
        this.method = method;
    }

    private boolean equalsPattern(String other){
        return keyPattern.equals(other) || keyPattern.matches(other) || other.matches(keyPattern);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RoutItem){
            return equalsPattern(((RoutItem)obj).keyPattern);
        }else if(obj instanceof String){
            return equalsPattern((String)obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
