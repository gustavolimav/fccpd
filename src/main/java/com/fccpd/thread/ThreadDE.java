package com.fccpd.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadDE {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> valuesAsList = _arrayToList(values);

        List<List<Integer>> listPartition = partitionDate(valuesAsList, 3);

        for (List<Integer> list : listPartition) {
            Integer[] listArray = _listToArray(list);

            _runThread(listArray);
        }
    }

    private static List<Integer> _arrayToList(int[] values) {
        List<Integer> originalList = new ArrayList<Integer>();

        for(int value: values) {
            originalList.add(value);
        }
        return originalList;
    }

    private static Integer[] _listToArray(List<Integer> list) {
        Integer[] listArray = new Integer[list.size()];

        list.toArray(listArray);
        return listArray;
    }

    private static void _runThread(Integer[] listArray) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                _timeCalculatorToComputePrimeFactorsMethod(listArray, "Thread " +
                        Thread.currentThread().getId() + " time: ");
            }
        }).start();
    }

    private static List<List<Integer>> partitionDate(List<Integer> originalList, int partitionSize) {
        List<List<Integer>> partitions = new LinkedList<List<Integer>>();

        for (int i = 0; i < originalList.size(); i += partitionSize) {
            partitions.add(originalList.subList(i,
                    Math.min(i + partitionSize, originalList.size())));
        }

        return partitions;
    }

    private static List<int[]> _partitionDate(int[] values) {
        int[] values1 = new int[values.length / 2];
        int[] values2 = new int[values.length / 2];

        for (int i = 0; i < values.length / 2; i++) {
            values1[i] = values[i];
            values2[i] = values[i + values.length / 2];
        }

        return List.of(values1, values2);
    }
    private static int[] _computePrimeFactors(Integer[] values) {
        int[] factors = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            factors[i] = _numPrimeFactors(values[i]);
        }

        return factors;
    }

    private static int _numPrimeFactors(int number) {
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

    private static void _timeCalculatorToComputePrimeFactorsMethod(Integer[] values, String x) {
        long startTime = System.nanoTime();

        _computePrimeFactors(values);

        long finalTime = System.nanoTime();

        System.out.println(x + (finalTime - startTime));
    }
}
