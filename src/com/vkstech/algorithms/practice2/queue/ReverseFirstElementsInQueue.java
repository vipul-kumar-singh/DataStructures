package com.vkstech.algorithms.practice2.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstElementsInQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            queue.add(i);

        queue.forEach(System.out::print);
        System.out.println();

        reverseFirstElements(queue, 3);
        queue.forEach(System.out::print);
    }

    private static void reverseFirstElements(Queue<Integer> queue, int k) {
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

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while (i < queue.size()) {
            queue.add(queue.remove());
            i++;
        }
    }
}
