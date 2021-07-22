package com.vkstech.algorithms.practice.queue;

import java.util.Stack;
import java.util.StringJoiner;

public class QueueWithStacks<T> {

    private Stack<T> s1;
    private Stack<T> s2;

    public QueueWithStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();

    }

    public void enqueue(T data) {
        s1.push(data);
        System.out.println(data + " is enqueued to queue");

    }

    public void dequeue() {
        if (s1.empty()) {
            System.out.println("Queue is empty");
            return;
        }

        while (!s1.empty())
            s2.push(s1.pop());

        T data = s2.pop();

        while (!s2.empty())
            s1.push(s2.pop());

        System.out.println(data + " is dequeued from queue");
    }

    public void print() {
        if (s1.empty()) {
            System.out.println("Queue is empty");
            return;
        }

        while (!s1.empty())
            s2.push(s1.pop());

        StringJoiner sj = new StringJoiner("->");

        while (!s2.empty()) {
            sj.add(s2.peek().toString());
            s1.push(s2.pop());
        }

        System.out.println(sj);
    }

    public static void main(String[] args) {
        QueueWithStacks<Integer> queue = new QueueWithStacks<>();
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.dequeue();

    }
}
