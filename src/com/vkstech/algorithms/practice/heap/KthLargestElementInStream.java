package com.vkstech.algorithms.practice.heap;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Kth largest element in a stream
 * Given an input stream arr[] of n integers.
 * Find the Kth largest element for each element in the stream and if the Kth element doesn't exist, return -1.
 */
public class KthLargestElementInStream {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        int k = 4;

        printKthLargestElements(input, k);
    }

    public static void printKthLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        IntStream.range(0, arr.length).forEach(i -> {
            if (priorityQueue.size() == k) {
                int top = priorityQueue.peek();
                if (arr[i] > top) {
                    priorityQueue.poll();
                    priorityQueue.add(arr[i]);
                }
                print(top);
            } else {
                priorityQueue.add(arr[i]);
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
