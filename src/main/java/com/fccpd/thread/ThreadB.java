package com.fccpd.thread;

import static com.fccpd.thread.ThreadUtil.computePrimeFactors;
import static com.fccpd.thread.ThreadUtil.timeCalculatorToComputePrimeFactorsMethod;

public class ThreadB {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        runThread(values);

        System.out.println("Thread 1 time: " + timeCalculatorToComputePrimeFactorsMethod(values));
    }

    private static void runThread(int[] values) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 time: " + timeCalculatorToComputePrimeFactorsMethod(values));
            }
        }).start();
    }
}
