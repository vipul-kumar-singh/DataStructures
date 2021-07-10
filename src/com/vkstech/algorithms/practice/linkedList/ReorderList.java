package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import java.util.Stack;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
 * For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3
 */
public class ReorderList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 1; i++)
            linkedList.insert(i);

        reorder(linkedList);
        printLinkedList(linkedList);
    }

    private static void reorder(LinkedList linkedList) {
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

        // Add elements after mid in stack to reverse them
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            Node temp = slow;
            slow = slow.next;
            temp.next = null;
            stack.push(temp);
        }

        // Merge stack and linked list elements
        Node previous = linkedList.head;
        Node current = previous.next;
        while(current != null){
            Node node = stack.pop();
            node.next = previous.next;
            previous.next = node;

            previous = current;
            current = current.next;
        }

        // Add remaining stack elements in linked list
        while(!stack.empty()){
            Node node = stack.pop();
            node.next = previous.next;
            previous.next = node;
            previous= previous.next;
        }
    }
}
