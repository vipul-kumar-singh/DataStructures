package com.vkstech.algorithms.bookProblems.linkedlist;

public class UnrolledLinkedList {

    private final int MAX_ELEMENTS;
    private int length;
    private Node head;
    private final int capacity;

    public UnrolledLinkedList(int maxElements) {
        MAX_ELEMENTS = maxElements;
        length = 0;
        capacity = maxElements / 2 + 1;
    }

    public class Node {
        int numElements = 0;
        Node next;
        int[] array = new int[MAX_ELEMENTS];
    }

    public int getLength() {
        return length;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            for (int i = 0; i < temp.numElements; i++) {
                System.out.print(temp.array[i] + " ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void insert(int data) {
        if (head == null) {
            head = new Node();
            head.array[head.numElements++] = data;
            length++;
            return;
        }

        Node temp = head;
        Node prev = temp;
        while (temp != null) {
            if (temp.numElements < capacity) {
                temp.array[temp.numElements++] = data;
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        Node newNode = new Node();
        newNode.array[newNode.numElements++] = data;
        prev.next = newNode;
        length++;

    }

    public void delete(int data) {
        if (length == 0) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        Node prev = temp;

        while (temp != null) {
            for (int i = 0; i < temp.numElements; i++) {
                if (temp.array[i] == data) {
                    shiftArray(temp.array, i, temp.numElements);
                    temp.numElements--;
                    if (temp.numElements == 0) {
                        prev.next = temp.next;
                        temp.next = null;
                        length--;
                    }
                    return;
                }
            }
            prev = temp;
            temp = temp.next;
        }
    }

    private void shiftArray(int[] array, int i, int numElements) {
        for (; i < numElements; i++) {
            array[i] = array[i + 1];
        }
    }

    public static void main(String[] args) {
        UnrolledLinkedList ull = new UnrolledLinkedList(3);

        ull.insert(1);
        ull.insert(2);
        ull.insert(3);
        ull.insert(4);
        ull.insert(5);

        ull.print();

        System.out.println(ull.getLength());

        ull.delete(2);
        ull.delete(3);
        ull.delete(4);

        ull.insert(2);
        ull.insert(3);
        ull.insert(4);

    }


}
