package com.vkstech.algorithms.practice3.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        System.out.println(getKthLargestElement(arr1, 4));

        int[] arr2 = {3, 2, 1, 3, 3};
        System.out.println(getKthLargestElement(arr2, 2));
    }

    private static int getKthLargestElement(int[] arr, int k) {
        if (k == 0 || k > arr.length) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }


        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }
}
