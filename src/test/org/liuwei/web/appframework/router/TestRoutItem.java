package org.liuwei.web.appframework.router;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by apple on 2017/1/31.
 */
public class TestRoutItem {
    @Test
    public void shouldEqual(){
        assertEquals(new RoutItem("/a",null), new RoutItem("/a", null));
        assertEquals(new RoutItem("/a", null), "/a");
        assertEquals(new RoutItem("/a/[^/]+", null),"/a/123");
        assertEquals(new RoutItem("/a/[^/]+/b", null),"/a/123/b");
        assertEquals(new RoutItem("/a/[^/]+/[^/]+", null),"/a/123/b");
        assertEquals(new RoutItem("[^/]+", null),"123");
    }
}
