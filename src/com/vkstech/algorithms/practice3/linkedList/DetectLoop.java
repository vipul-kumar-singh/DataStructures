package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
public class DetectLoop {

    public static void main(String[] args) {

        // -------------------------------
        // Example 1: pos = 2 (loop exists)
        // -------------------------------
        int[] arr1 = {1, 3, 4};
        Node head1 = buildList(arr1);
        createLoop(head1, 2);

        System.out.println("Example 1: Loop expected = true");
        System.out.println("Detected: " + detectLoop(head1));
        System.out.println("--------------------------------");

        // -------------------------------
        // Example 2: pos = 0 (no loop)
        // -------------------------------
        int[] arr2 = {1, 8, 3, 4};
        Node head2 = buildList(arr2);
        createLoop(head2, 0);

        System.out.println("Example 2: Loop expected = false");
        System.out.println("Detected: " + detectLoop(head2));
        System.out.println("--------------------------------");

        // -------------------------------
        // Example 3: pos = 1 (loop exists)
        // -------------------------------
        int[] arr3 = {1, 7, 8, 10};
        Node head3 = buildList(arr3);
        createLoop(head3, 1);

        System.out.println("Example 3: Loop expected = true");
        System.out.println("Detected: " + detectLoop(head3));
        System.out.println("--------------------------------");


        // -------------------------------
        // Example 4: pos = 0 (no loop)
        // -------------------------------
        int[] arr4 = {11};
        Node head4 = buildList(arr4);
        createLoop(head4, 0);

        System.out.println("Example 4: Loop expected = false");
        System.out.println("Detected: " + detectLoop(head4));
        System.out.println("--------------------------------");
    }

    // Utility: create a linked list from array
    public static Node buildList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Utility: create loop at position 'pos' (1-based index)
    public static void createLoop(Node head, int pos) {
        if (pos == 0) return;

        Node loopNode = null;
        Node curr = head;
        int index = 1;

        while (curr.next != null) {
            if (index == pos) loopNode = curr;
            curr = curr.next;
            index++;
        }
        curr.next = loopNode; // create loop
    }

    // Utility: print list safely (prints limited nodes)
    public static void printList(Node head) {
        Node curr = head;
        int count = 0;

        while (curr != null && count < 20) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
            count++;
        }
        System.out.println(curr == null ? "NULL" : "LOOP...");
    }

    public static boolean detectLoop(Node head) {
        if (head == null)
            return false;

        Node first = head;
        Node second = head;

        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;

            if (first == second)
                return true;
        }

        return false;
    }
}
