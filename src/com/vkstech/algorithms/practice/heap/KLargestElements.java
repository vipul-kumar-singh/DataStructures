package com.vkstech.algorithms.practice.heap;

import java.util.PriorityQueue;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * K largest elements
 * Given an array of N positive integers, print k largest elements from the array.
 */
public class KLargestElements {

    public static void main(String[] args) {
        int[] input = {12, 5, 787, 1, 23};
        int k = 2;

        printKLargestElements(input, k);

        int[] input2 = {1, 23, 12, 9, 30, 2, 50};
        int k2 = 3;

        printKLargestElements(input2, k2);
    }

    public static void printKLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        IntStream.range(0, arr.length).forEach(i -> {
            if (priorityQueue.size() == k) {
                if (arr[i] > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(arr[i]);
                }
            } else {
                priorityQueue.add(arr[i]);
            }
        });

        StringJoiner sj = new StringJoiner(" ");
        while (!priorityQueue.isEmpty())
            sj.add(priorityQueue.poll().toString());
        System.out.println(sj);
    }
}
