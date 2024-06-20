package com.vkstech.algorithms.practice2.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

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
        if (arr.length < k)
            return;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        Arrays.stream(arr).forEach(i -> {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() < i) {
                    priorityQueue.poll();
                    priorityQueue.add(i);
                }
            } else {
                priorityQueue.add(i);
            }
        });

        while (!priorityQueue.isEmpty())
            System.out.print(priorityQueue.poll() + " ");
        System.out.println();
    }
}
