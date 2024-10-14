package com.vkstech.algorithms.practice2.mostAsked;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15}; // 3,4,7,10,15,20
        System.out.println(getKthSmallestElementInArray(input, 3));
        System.out.println(getKthLargestElementInArray(input, 3));
    }

    private static Integer getKthLargestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int num : arr) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() < num) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            } else {
                priorityQueue.add(num);
            }
        }

        return priorityQueue.peek();
    }

    private static Integer getKthSmallestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int num : arr) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() > num) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            } else {
                priorityQueue.add(num);
            }
        }

        return priorityQueue.peek();
    }
}
