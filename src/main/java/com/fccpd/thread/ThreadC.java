package com.fccpd.thread;

public class ThreadC {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread creation time: " + timeCalculatorToThreadCreation());
    }

    private static long timeCalculatorToThreadCreation() throws InterruptedException {
        long startTime = System.nanoTime();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        thread.start();

        thread.join();

        long finalTime = System.nanoTime();

        return finalTime - startTime;
    }
}
