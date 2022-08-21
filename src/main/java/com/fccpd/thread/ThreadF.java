package com.fccpd.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.fccpd.thread.ThreadUtil.partitionDate;
import static com.fccpd.thread.ThreadUtil.timeCalculatorToComputePrimeFactorsMethod;

public class ThreadF {
    public static void main(String[] args) {

        int valuesSize = Integer.parseInt(args[0]);
        int threadNumber = Integer.parseInt(args[1]);

        int[] values = _randomArray(valuesSize);

        List<Integer> valuesAsList = _arrayToList(values);

        List<List<Integer>> listPartition = partitionDate(valuesAsList, valuesSize
        / threadNumber);

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

    private static int[] _randomArray(int size) {
        int[] array = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt();
        }

        return array;
    }

    private static void _runThread(Integer[] listArray) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " +
                        Thread.currentThread().getId() + " time: " +
                        timeCalculatorToComputePrimeFactorsMethod(listArray));
            }
        }).start();
    }
}
