package com.vkstech.algorithms.practice2.queue;

import java.util.Stack;
import java.util.StringJoiner;

public class QueueUsingStack {

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;


    public QueueUsingStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enqueue(int data) {
        s1.push(data);
    }

    public int dequeue() {
        if (s1.isEmpty())
            return -1;

        while (s1.size() != 1) {
            s2.add(s1.pop());
        }

        int data = s1.pop();

        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }

        return data;
    }

    public int getLength() {
        return s1.size();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("->");
        s1.forEach(n -> sj.add(String.valueOf(n)));
        return sj.toString();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue);

        for (int i = 0; i <= 5; i++) {
            System.out.println(queue.dequeue());
        }

        System.out.println(queue);
    }
}
