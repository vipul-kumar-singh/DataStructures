package com.vkstech.algorithms.practice2.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {

    public static void printMedian(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(arr[0]);

        double median = arr[0];
        System.out.println(median);

        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];

            if (maxHeap.size() == minHeap.size()) {
                if (data < median) {
                    maxHeap.add(data);
                    median = (double) maxHeap.peek();
                } else {
                    minHeap.add(data);
                    median = (double) minHeap.peek();
                }

                System.out.println(median);
                continue;
            }


            if (maxHeap.size() > minHeap.size()) {
                if (data < median) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(data);
                } else {
                    minHeap.add(data);
                }
            } else {
                if (data > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(data);
                } else {
                    maxHeap.add(data);
                }
            }

            median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
            System.out.println(median);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
    }
}
