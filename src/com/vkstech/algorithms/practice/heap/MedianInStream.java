package com.vkstech.algorithms.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find median in a stream
 * Given an input stream of N integers. The task is to insert these numbers into a new stream and
 * find the median of the stream formed by each insertion of X to the new stream.
 */
public class MedianInStream {

    public static void printMedian(int[] a) {

        double median = a[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(a[0]);
        System.out.println(median);

        for (int i = 1; i < a.length; i++) {
            int data = a[i];

            if (maxHeap.size() > minHeap.size()) {
                if (data < median) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(data);
                } else
                    minHeap.add(data);
                median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else if (maxHeap.size() == minHeap.size()) {
                if (data < median) {
                    maxHeap.add(data);
                    median = (double) maxHeap.peek();
                } else {
                    minHeap.add(data);
                    median = (double) minHeap.peek();
                }
            } else {
                if (data > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(data);
                } else
                    maxHeap.add(data);
                median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }
            System.out.println(median);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
    }
}
