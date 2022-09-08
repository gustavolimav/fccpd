package com.fccpd.thread;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ThreadF {

    public HashMap<String, Integer> multipleThreads(int valuesSize, int threadNumber) throws InterruptedException {
        long initialTime = System.currentTimeMillis();

        int[] values = _randomArray(valuesSize);

        List<Integer> valuesAsList = _arrayToList(values);

        List<List<Integer>> listPartition = ThreadUtil.partitionDate(
                valuesAsList, valuesSize / threadNumber);

        ArrayList<Thread> threads = getThreads(listPartition);

        for(Thread thread : threads) {
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        long finalTime = System.currentTimeMillis();

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("size", valuesSize);
        hashMap.put("threadNumber", threadNumber);
        hashMap.put("time", (int) (finalTime - initialTime));

        return hashMap;
    }

    private ArrayList<Thread> getThreads(List<List<Integer>> listPartition) {
        ArrayList<Thread> threads = new ArrayList<>();

        for (List<Integer> list : listPartition) {
            Integer[] listArray = _listToArray(list);

            threads.add(_createThread(listArray));
        }

        return threads;
    }

    private List<Integer> _arrayToList(int[] values) {
        List<Integer> originalList = new ArrayList<>();

        for(int value: values) {
            originalList.add(value);
        }

        return originalList;
    }

    private Integer[] _listToArray(List<Integer> list) {
        Integer[] listArray = new Integer[list.size()];

        list.toArray(listArray);

        return listArray;
    }

    private int[] _randomArray(int size) {
        int[] array = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt();
        }

        return array;
    }

    private Thread _createThread(Integer[] listArray) {
        return new Thread(() -> ThreadUtil.timeCalculatorToComputePrimeFactorsMethod(listArray));
    }
}
