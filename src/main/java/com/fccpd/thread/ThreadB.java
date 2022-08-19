package com.fccpd.thread;

public class ThreadB {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        runThread(values);

        timeCalculatorToComputePrimeFactorsMethod(values, "Thread 1 time: ");
    }

    private static int[] computePrimeFactors(int[] values) {
        int[] factors = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            factors[i] = numPrimeFactors(values[i]);
        }
        return factors;
    }

    private static int numPrimeFactors(int number) {
        int primeFactors = 0;
        int n = number;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                primeFactors++;
                n /= i;
            }
        }
        return primeFactors;
    }

    private static void runThread(int[] values) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                timeCalculatorToComputePrimeFactorsMethod(values, "Thread 2 time: ");
            }
        }).start();
    }

    private static void timeCalculatorToComputePrimeFactorsMethod(int[] values, String x) {
        long startTime = System.nanoTime();

        computePrimeFactors(values);

        long finalTime = System.nanoTime();

        System.out.println(x + (finalTime - startTime));
    }
}
