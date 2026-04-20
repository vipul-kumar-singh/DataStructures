package com.vkstech.algorithms.practice3.queue;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/queue-using-two-stacks/1
public class MStackedQueue {

    private final Stack<Integer> queue = new Stack<>();
    private final Stack<Integer> stack = new Stack<>();

    public void enqueue(int data) {
        queue.push(data);
    }

    public int dequeue() {
        if (queue.isEmpty()) {
            return -1;
        }

        while (!queue.isEmpty()) {
            stack.push(queue.pop());
        }

        int data = stack.pop();

        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }

        return data;
    }

    public void print() {
        System.out.println(queue);
    }
}

