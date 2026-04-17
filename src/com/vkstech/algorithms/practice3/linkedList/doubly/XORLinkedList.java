package com.vkstech.algorithms.practice3.linkedList.doubly;

// https://www.geeksforgeeks.org/problems/xor-linked-list/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    int npx; // XOR of identityHashCodes of prev and next

    Node(int data) {
        this.data = data;
        this.npx = 0;
    }
}

public class XORLinkedList {

    Map<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) {

        XORLinkedList sol1 = new XORLinkedList();
        Node head = null;

        System.out.println("=== Test 1: Insert multiple values ===");
        int[] arr = {9, 5, 4, 7, 3, 10};
        for (int x : arr) head = sol1.insert(head, x);

        ArrayList<Integer> forward = sol1.getList(head);
        System.out.println("Forward:  " + forward);

        Collections.reverse(forward);
        System.out.println("Backward: " + forward);


        System.out.println("\n=== Test 2: Empty list ===");
        XORLinkedList sol2 = new XORLinkedList();
        Node head2 = null;
        System.out.println("Forward:  " + sol2.getList(head2));


        System.out.println("\n=== Test 3: Single element ===");
        XORLinkedList sol3 = new XORLinkedList();
        Node head3 = sol3.insert(null, 42);
        System.out.println("Forward:  " + sol3.getList(head3));


        System.out.println("\n=== Test 4: Random insertions ===");
        XORLinkedList sol4 = new XORLinkedList();
        Node head4 = null;
        for (int i = 1; i <= 7; i++) {
            head4 = sol4.insert(head4, i * 11);
        }
        System.out.println("Forward:  " + sol4.getList(head4));


        System.out.println("\n=== Test 5: Stress test (20 inserts) ===");
        XORLinkedList sol5 = new XORLinkedList();
        Node head5 = null;
        for (int i = 1; i <= 20; i++) {
            head5 = sol5.insert(head5, i);
        }
        System.out.println("Forward:  " + sol5.getList(head5));
    }

    private int id(Node node) {
        return node == null ? 0 : System.identityHashCode(node);
    }

    private Node XOR(Node a, Node b) {
        return map.get(id(a) ^ id(b));
    }

    public Node insert(Node head, int data) {
        Node newNode = new Node(data);
        map.put(id(newNode), newNode);

        newNode.npx = id(head); // XOR(null, head)

        if (head != null) {
            int next = head.npx ^ 0; // XOR(prev=null, next)
            head.npx = id(newNode) ^ next;
        }

        return newNode;
    }

    public ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> res = new ArrayList<>();

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            res.add(curr.data);
            Node next = XOR(prev, curr);
            prev = curr;
            curr = next;
        }

        return res;
    }
}