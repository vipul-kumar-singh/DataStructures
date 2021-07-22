package com.vkstech.algorithms.practice.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reverse First K elements of Queue
 * Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue,
 * leaving the other elements in the same relative order.
 * Eg: Input: 1->2->3->4->5, k = 3
 * Output: 3->2->1->->5
 */
public class ReverseElementsInQ {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            queue.add(i);

        reverseQueueElements(queue, 3);
        queue.forEach(System.out::println);
    }

    private static void reverseQueueElements(Queue<Integer> queue, int k) {
        if (queue == null || queue.isEmpty() || k == 0)
            return;

        if (k < 0 || k > queue.size()) {
            System.out.println("Invalid value of k");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < k) {
            stack.push(queue.remove());
            i++;
        }

        while (!stack.empty())
            queue.add(stack.pop());

        while (i < queue.size()) {
            queue.add(queue.remove());
            i++;
        }
    }

}
