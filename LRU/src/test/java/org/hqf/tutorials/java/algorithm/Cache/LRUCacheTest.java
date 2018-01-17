package org.hqf.tutorials.java.algorithm.Cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {


    private LRUCache lruCache;

    @Before
    public void init() {
        lruCache = new LRUCache(3);
    }


    @Test
    public void TestLRUCach() {

        lruCache.put("user1", "Frank");
        lruCache.put("user2", "Frank2");
        lruCache.put("user3", "Frank3");
        lruCache.put("user4", "Frank4");


        Object o = lruCache.get("user1");
        Assert.assertNull(o);


        Object o2 = lruCache.get("user2");
        Assert.assertNotNull(o2);
        System.out.println("o2 = " + o2);



        lruCache.put("user5", "Frank5");

        Object o3=lruCache.get("user3");
        System.out.println("o3 = " + o3);
        Assert.assertNull(o3);

        o2 = lruCache.get("user2");
        Assert.assertNotNull(o2);
        System.out.println("o2 = " + o2);



    }
    @Test
    public void get() {
    }

    @Test
    public void put() {
    }
}