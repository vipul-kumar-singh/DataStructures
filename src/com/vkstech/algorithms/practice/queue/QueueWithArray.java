package com.vkstech.algorithms.practice.queue;

import java.util.StringJoiner;

public class QueueWithArray {

    private int[] queue;
    private int head;
    private int tail;

    public QueueWithArray() {
        this(10); // default max size
    }

    public QueueWithArray(int max_size) {
        this.queue = new int[max_size];
        head = 0;
        tail = 0;
    }

    public void enqueue(int data) {
        if (tail == queue.length) {
            System.out.println("Queue is full");
            return;
        }

        queue[tail++] = data;
        System.out.println(data + " is enqueued to queue");
    }

    public void dequeue() {
        if (head == tail) {
            System.out.println("Queue is empty");
            return;
        }
        int data = queue[head];
        System.arraycopy(queue, 1, queue, 0, tail - 1);
        tail--;
        System.out.println(data + " is dequeued from queue");
    }

    public void print() {
        StringJoiner sj = new StringJoiner("->");
        for (int i = head; i < tail; i++)
            sj.add(String.valueOf(queue[i]));
        System.out.println(sj);
    }

    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray(3);
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.print();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();


    }

}
