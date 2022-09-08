package com.fccpd.thread;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ThreadFTest {

    @Test
    public void testThreadF() throws InterruptedException {
        ThreadF threadF = new ThreadF();

        HashMap<String, Integer> stringIntegerHashMap = threadF.multipleThreads(100, 100);

        Assert.assertEquals((int)stringIntegerHashMap.get("size"), 100);
    }
}
