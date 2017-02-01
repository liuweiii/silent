package org.liuwei.web.appframework.router;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by apple on 2017/1/31.
 */
public class TestPathPattern {
    @Test
    public void shouldEqual(){
        assertEquals(new PathPattern("/a"), new PathPattern("/a"));
        assertEquals(new PathPattern("/a"), "/a");
        assertEquals(new PathPattern("/a/[^/]+"),"/a/123");
        assertEquals(new PathPattern("/a/[^/]+/b"),"/a/123/b");
        assertEquals(new PathPattern("/a/[^/]+/[^/]+"),"/a/123/b");
        assertEquals(new PathPattern("[^/]+"),"123");
    }
}
