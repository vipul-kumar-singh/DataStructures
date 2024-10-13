package com.vkstech.algorithms.practice2.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class StackUsingQueue {

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;


    public StackUsingQueue() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int data) {
        q1.add(data);
    }

    public int pop() {
        if (q1.isEmpty())
            return -1;

        while (q1.size() != 1) {
            q2.add(q1.remove());
        }

        int data = q1.remove();

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        return data;
    }

    public int getLength() {
        return q1.size();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("->");
        q1.forEach(n -> sj.add(String.valueOf(n)));
        return sj.toString();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        for (int i = 0; i <= 5; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack);
    }
}
