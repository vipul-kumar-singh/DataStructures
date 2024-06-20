package com.vkstech.algorithms.practice2.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        int k = 4;

        printKthLargestElements(input, k);
    }

    public static void printKthLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        Arrays.stream(arr).forEach(n -> {
            if (priorityQueue.size() == k) {
                int top = priorityQueue.peek();
                if (n > top) {
                    priorityQueue.poll();
                    priorityQueue.add(n);
                }
                print(top);
            } else {
                priorityQueue.add(n);
            }
            if (priorityQueue.size() != k)
                print(-1);
        });
        if (!priorityQueue.isEmpty())
            print(priorityQueue.peek());
    }

    private static void print(int val) {
        System.out.print(val + " ");
    }
}
