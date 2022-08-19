package com.fccpd.thread;

public class ThreadC {
    public static void main(String[] args) {
        Long time = timeCalculatorToThreadCreation();

        System.out.println("Thread creation time: " + time);
    }

    private static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    private static long timeCalculatorToThreadCreation() {
        long startTime = System.nanoTime();

        runThread();

        long finalTime = System.nanoTime();

        return finalTime - startTime;
    }
}
