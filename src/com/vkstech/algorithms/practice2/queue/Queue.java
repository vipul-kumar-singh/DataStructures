package com.vkstech.algorithms.practice2.queue;

import java.util.StringJoiner;

public class Queue {
    Node head;
    Node tail;
    private int length = 0;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        length++;
    }

    public int dequeue() {
        if (head == null)
            return -1;

        Node node = head;
        head = head.next;
        node.next = null;
        length--;

        return node.data;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }

        StringJoiner sj = new StringJoiner("->");
        Node temp = head;

        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }

        return sj.toString();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.getLength());
        System.out.println(queue);

        for (int i = 0; i <= 5; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
