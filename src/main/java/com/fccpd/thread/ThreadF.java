package com.fccpd.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadF {
    public static void main(String[] args) throws InterruptedException {
        long initialTime = System.currentTimeMillis();

        int valuesSize = Integer.parseInt(args[0]);
        int threadNumber = Integer.parseInt(args[1]);

        int[] values = _randomArray(valuesSize);

        List<Integer> valuesAsList = _arrayToList(values);

        List<List<Integer>> listPartition = ThreadUtil.partitionDate(valuesAsList, valuesSize
        / threadNumber);

        ArrayList<Thread> threads = new ArrayList<Thread>();

        for (List<Integer> list : listPartition) {
            Integer[] listArray = _listToArray(list);

            threads.add(_createThread(listArray));
        }

        for(Thread thread : threads) {
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        long finalTime = System.currentTimeMillis();

        System.out.println("Values size: " + valuesSize + " Thread number: " + threadNumber + " Time: " + (finalTime - initialTime));
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

    private static Thread _createThread(Integer[] listArray) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                        ThreadUtil.timeCalculatorToComputePrimeFactorsMethod(listArray);
            }
        });
    }
}
