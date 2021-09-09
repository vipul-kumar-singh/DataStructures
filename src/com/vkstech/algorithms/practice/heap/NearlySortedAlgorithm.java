package com.vkstech.algorithms.practice.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Nearly Sorted Algorithm
 * Given an array of n elements, where each element is at most k away from its target position.
 * The task is to print array in sorted form.
 */
public class NearlySortedAlgorithm {

    private static void kSort(int[] arr, int n, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k + 1; i++)
            priorityQueue.add(arr[i]);

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int k = 3;
        int arr[] = {2, 6, 3, 12, 56, 8};
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}
