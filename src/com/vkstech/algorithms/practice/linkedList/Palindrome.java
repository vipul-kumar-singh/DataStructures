package com.vkstech.algorithms.practice.linkedList;

import java.util.Stack;

/**
 * Check if Linked List is Palindrome
 */
public class Palindrome extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(1);

        System.out.println(isPalindrome(linkedList));
    }

    private static boolean isPalindrome(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null)
            return true;

        Stack<Integer> stack = new Stack<>();

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.data)
                return false;
            slow = slow.next;
        }

        return true;
    }
}
