package com.vkstech.algorithms.practice3.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
public class ReverseFirstK {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;

        System.out.println(q);

        reverseFirstK(q, k);

        System.out.println(q);
    }

    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q == null || q.isEmpty() || q.size() < k) {
            return q;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        while (!q.isEmpty()) {
            queue.add(q.remove());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            q.add(queue.remove());
        }

        return q;
    }
}
