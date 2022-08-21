package com.fccpd.thread;

import java.util.ArrayList;
import java.util.List;

import static com.fccpd.thread.ThreadUtil.*;

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
                System.out.println("Thread " +
                        Thread.currentThread().getId() + " time: " +
                            _timeCalculatorToComputePrimeFactorsMethod(listArray));
            }
        }).start();
    }

    private static long _timeCalculatorToComputePrimeFactorsMethod(Integer[] values) {
        long startTime = System.nanoTime();

        computePrimeFactors(values);

        long finalTime = System.nanoTime();

        return finalTime - startTime;
    }
}
