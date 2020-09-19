package com.vkstech.data.structures;

import java.util.Objects;

public class MyQueue {

    private Node head;
    private Node tail;

    int size;
    private final int MAX_SIZE;

    public MyQueue(int max) {
        MAX_SIZE = max;
        size = 0;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int data) {
        if (size == MAX_SIZE) {
            System.out.println("Queue Overflow");
            return;
        }

        Node node = new Node(data);

        if (isEmpty())
            head = node;
        else
            tail.next = node;
        tail = node;
        size++;
        System.out.println(data + " inserted at tail of the queue.");
    }

    public void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue Overflow");
            return;
        }

        Node node = head;
        if (head == tail)
            tail = tail.next;
        head = head.next;
        node.next = null;
        size--;
        System.out.println(node.data + " removed from head of the queue.");
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        Node start = head;
        while (Objects.nonNull(start)){
            System.out.print(start.data + "\t");
            start = start.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return Objects.isNull(head) && Objects.isNull(tail);
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        myQueue.enqueue(6);

        myQueue.display();

        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();

        myQueue.display();

        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();

        myQueue.display();
    }
}
