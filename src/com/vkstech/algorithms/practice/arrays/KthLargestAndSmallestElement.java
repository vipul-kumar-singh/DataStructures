package com.vkstech.algorithms.practice.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find the Kth largest and Kth smallest number in an array
 */
public class KthLargestAndSmallestElement {

    public static int getKthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int val : arr) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() > val) {
                    priorityQueue.poll();
                    priorityQueue.add(val);
                }
            } else {
                priorityQueue.add(val);
            }
        }
        return priorityQueue.peek();
    }

    public static int getKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int val : arr) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() < val) {
                    priorityQueue.poll();
                    priorityQueue.add(val);
                }
            } else {
                priorityQueue.add(val);
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15}; // 3,4,7,10,15,20
        System.out.println(getKthSmallestElement(input, 3));
        System.out.println(getKthLargestElement(input, 3));
    }
}
