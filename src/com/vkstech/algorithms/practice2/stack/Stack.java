package com.vkstech.algorithms.practice2.stack;

public class Stack {
    Node head;
    int length = 0;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
        length++;
    }

    public Node pop() {
        if (head == null)
            return null;

        Node temp = head;
        head = head.next;
        temp.next = null;

        length--;
        return temp;
    }

    public Node peek() {
        if (head == null)
            return null;

        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.isEmpty());

        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.peek().data);
        System.out.println(stack.pop().data);

        System.out.println(stack.isEmpty());

    }

}
