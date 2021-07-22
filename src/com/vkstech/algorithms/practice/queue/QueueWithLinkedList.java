package com.vkstech.algorithms.practice.queue;

import java.util.StringJoiner;

public class QueueWithLinkedList<T> {
    private Node<T> head;

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
        System.out.println(data + " is enqueued to queue");
    }

    public T dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return null;
        }

        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println(temp.data + " is dequeued from queue");
        return temp.data;
    }

    public T peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return null;
        }

        return head.data;
    }

    public void print() {
        if (head == null)
            return;

        Node<T> temp = head;
        StringJoiner sj = new StringJoiner("->");
        while (temp != null) {
            sj.add(temp.data.toString());
            temp = temp.next;
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.dequeue();

    }

}
