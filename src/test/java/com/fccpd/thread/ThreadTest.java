package com.fccpd.thread;

import org.junit.Test;

public class ThreadFTest {

    @Test
    public void testThreadF() throws InterruptedException {
        ThreadF t = new ThreadF();

        t.main(new String[] { "100", "100"});
    }
}
