package com.fccpd.thread;

public class ThreadB {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        runThread(values);

        System.out.println("Thread 1 time: " + ThreadUtil.timeCalculatorToComputePrimeFactorsMethod(values));
    }

    private static void runThread(int[] values) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 time: " + ThreadUtil.timeCalculatorToComputePrimeFactorsMethod(values));
            }
        }).start();
    }
}
