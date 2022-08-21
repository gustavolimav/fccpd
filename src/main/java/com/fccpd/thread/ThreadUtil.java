package com.fccpd.thread;

import java.util.LinkedList;
import java.util.List;

public class ThreadUtil {

    protected static int[] computePrimeFactors(int[] values) {
        int[] factors = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            factors[i] = numPrimeFactors(values[i]);
        }

        return factors;
    }

    protected static int[] computePrimeFactors(Integer[] values) {
        int[] factors = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            factors[i] = numPrimeFactors(values[i]);
        }

        return factors;
    }

    protected static long timeCalculatorToComputePrimeFactorsMethod(int[] values) {
        long startTime = System.nanoTime();

        computePrimeFactors(values);

        long finalTime = System.nanoTime();

        return finalTime - startTime;
    }

    protected static long timeCalculatorToComputePrimeFactorsMethod(Integer[] values) {
        long startTime = System.currentTimeMillis();

        computePrimeFactors(values);

        long finalTime = System.currentTimeMillis();

        return finalTime - startTime;
    }

    protected static List<List<Integer>> partitionDate(List<Integer> originalList, int partitionSize) {
        List<List<Integer>> partitions = new LinkedList<List<Integer>>();

        for (int i = 0; i < originalList.size(); i += partitionSize) {
            partitions.add(originalList.subList(i,
                    Math.min(i + partitionSize, originalList.size())));
        }

        return partitions;
    }

    protected static int numPrimeFactors(int number) {
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
}
