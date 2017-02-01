package org.liuwei.web.appframework.router;

/**
 * Created by apple on 2017/2/1.
 */
public class PathPattern {
    private String keyPattern;

    public PathPattern(String keyPattern){
        this.keyPattern = keyPattern;
    }

    private boolean equalsPattern(String other){
        return keyPattern.equals(other) || keyPattern.matches(other) || other.matches(keyPattern);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PathPattern){
            return equalsPattern(((PathPattern)obj).keyPattern);
        }else if(obj instanceof String){
            return equalsPattern((String)obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int end = keyPattern.indexOf("/");

        return keyPattern.substring(0, end == -1? keyPattern.length(): end).hashCode();
    }
}
