package com.vkstech.algorithms.practice2.queue;

import java.util.Arrays;

public class QueueUsingArray {

    private final int[] qArr;
    private final int maxSize;
    private int length;

    public QueueUsingArray(int n) {
        this.qArr = new int[n];
        maxSize = n;
        length = 0;
    }

    public void enqueue(int data) {
        if (length == maxSize) {
            System.out.println("Queue is full");
            return;
        }

        qArr[length++] = data;
    }

    public int dequeue() {
        if (length == 0)
            return -1;

        int data = qArr[0];
        System.arraycopy(qArr, 1, qArr, 0, length - 1);
        length--;
        return data;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "qArr=" + Arrays.toString(qArr) +
                '}';
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);

        for (int i = 0; i <= 5; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.getLength());
        System.out.println(queue);

        for (int i = 0; i <= 5; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
