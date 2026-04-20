package com.vkstech.algorithms.practice3.queue;

import java.util.StringJoiner;

public class MLinkedQueue {

    Node front;
    Node rear;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node node = new Node(data);

        if (isEmpty()) {
            front = node;
            rear = front;
            return;
        }

        rear.next = node;
        rear = rear.next;
    }

    public void dequeue() {
        if (isEmpty()) {
            return;
        }

        front = front.next;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.data;
    }

    public int size() {
        Node temp = front;

        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }


    public void print() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");

        Node temp = front;
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }

        System.out.println(sj);
    }
}
