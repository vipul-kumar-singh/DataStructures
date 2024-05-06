package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

import java.util.Stack;

public class Palindrome {

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
        if (linkedList == null || linkedList.head == null) {
            return false;
        }

        if (linkedList.head.next == null) {
            return true;
        }

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        Node temp = linkedList.head;
        while (!stack.isEmpty()) {
            if (stack.pop() != temp.data) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}
