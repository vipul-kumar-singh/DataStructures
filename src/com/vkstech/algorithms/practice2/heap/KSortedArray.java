package com.vkstech.algorithms.practice2.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KSortedArray {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {2, 6, 3, 12, 56, 8};
        kSort(arr, k);
        System.out.println("Following is sorted array");
        System.out.println(Arrays.toString(arr));
    }

    private static void kSort(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

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
}
