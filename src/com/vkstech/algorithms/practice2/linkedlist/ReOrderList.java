package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

import java.util.Stack;

public class ReOrderList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 9; i++)
            linkedList.insert(i);
        System.out.println(linkedList);

        reOrder(linkedList);
        System.out.println(linkedList);
    }

    private static void reOrder(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null)
            return;

        // Goto mid
        Node slow = linkedList.head;
        Node fast = linkedList.head;
        Node mid = slow;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;


        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            Node temp = slow;
            slow = slow.next;
            temp.next = null;
            stack.push(temp);
        }

        Node previous = linkedList.head;
        Node current = previous.next;

        while (current != null && !stack.isEmpty()) {
            Node temp = stack.pop();
            temp.next = current;

            previous.next = temp;

            previous = current;
            current = current.next;

        }

        while (!stack.isEmpty()) {
            previous.next = stack.pop();
            previous = previous.next;
        }
    }
}
