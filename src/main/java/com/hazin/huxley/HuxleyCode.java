package com.hazin.huxley;

import java.util.*;

public class HuxleyCode {
    public static void main() {
        Scanner input = new Scanner(System.in);

        verticesNumber = input.nextInt();
        arestasNumber = input.nextInt();
        testNumber = input.nextInt();

        arestas = new int[arestasNumber][2];
        ArrayList<Integer> elements = new ArrayList<>();

        for (int i = 0; i < arestasNumber; i++) {
            arestas[i][0] = input.nextInt();
            arestas[i][1] = input.nextInt();

            elements.add(arestas[i][0]);
            elements.add(arestas[i][1]);
        }

        removeDuplicates(elements);

        tests = new int[testNumber][2];

        for (int i = 0; i < testNumber; i++) {
            tests[i][0] = input.nextInt();
            tests[i][1] = input.nextInt();
        }

        System.out.println("--------\n");

        System.out.println("Caso de Teste #1 - BFS(" + tests[0][0] + ")\n");

        for(int element : elements) {
            System.out.println("Iniciando busca em largura a partir de " + element);
        }

        for (int i = 0; i < tests[0].length; i++) {
            buscaEmLargura(tests[i][0]);
        }
    }

    private static void buscaEmLargura(int verticeOrigemTest) {

        int[][] kdp = new int[verticesNumber][3];

        for (int no = 0; no < verticesNumber; no++) {
            kdp[no][0] = no;
            kdp[no][1] = distanceOfElements(no, verticeOrigemTest);
            kdp[no][2] = verticePredecessor();
        }

        for (int[] ints : kdp) {
            System.out.println(ints[0] + " | " + ints[1] + " | " + ints[2]);
        }
    }

    private static int distanceOfElements(int from, int to) {
        if (from == to) {
            return 0;
        }

        int distance = 0;

        for (int i = 0; i < arestas[0].length; i++) {
            if (arestas[i][0] == from) {
                if (arestas[i][1] == to) {
                    return 1;
                }
                distance += distanceOfElements(arestas[i][1], to);
            }
        }

        return distance;
    }

    private static int verticePredecessor() {
        return 0;
    }

    public static void removeDuplicates(ArrayList<Integer> list) {

        Set<Integer> set = new LinkedHashSet<>(list);

        list.clear();

        list.addAll(set);
    }

    private static int verticesNumber;
    private static int[][] arestas;
    private static int[][] tests;
    private static int arestasNumber;
    private static int testNumber;
}
