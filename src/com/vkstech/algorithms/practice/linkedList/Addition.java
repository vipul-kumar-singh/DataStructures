package com.vkstech.algorithms.practice.linkedList;

import java.util.Stack;

/**
 * Add two numbers represented by linked lists
 * Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.
 * The sum list is a linked list representation of the addition of two input numbers from the last.
 * Eg : Input : valueN[] = {4,5}, valueM[] = {3,4,5}
 * Output: {3, 9, 0}
 */
public class Addition extends LinkedList {

    public static void main(String[] args) {
        LinkedList num1 = new LinkedList();
        num1.insertMultiple(9, 5, 9);
        PrintLinkedList.printLinkedListOneline(num1);

        LinkedList num2 = new LinkedList();
        num2.insertMultiple(3, 4, 5);
        PrintLinkedList.printLinkedListOneline(num2);

        LinkedList sum = addLinkedList(num1, num2);
        PrintLinkedList.printLinkedListOneline(sum);

    }

    private static LinkedList addLinkedList(LinkedList num1, LinkedList num2) {
        if (num1 == null)
            return num2;

        if (num2 == null)
            return num1;

        Stack<Integer> s1 = getStackFromLinkedList(num1);
        Stack<Integer> s2 = getStackFromLinkedList(num2);

        Stack<Integer> s3 = new Stack<>();
        int carry = 0;
        int a = 0;
        int b = 0;
        while (!s1.empty() || !s2.empty()) {
            if (s1.empty()) {
                a = 0;
                b = s2.pop();
            } else if (s2.empty()) {
                a = s1.pop();
                b = 0;
            } else {
                a = s1.pop();
                b = s2.pop();
            }
            int sum = a + b + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            s3.push(sum);
        }

        if (carry > 0) {
            s3.push(carry);
        }

        return getLinkedListFromStack(s3);
    }

    public static Stack<Integer> getStackFromLinkedList(LinkedList linkedList) {
        Stack<Integer> stack = new Stack<>();
        Node temp = linkedList.head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        return stack;
    }

    public static LinkedList getLinkedListFromStack(Stack<Integer> stack) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(stack.pop());
        Node temp = linkedList.head;
        while (!stack.empty()) {
            temp.next = new Node(stack.pop());
            temp = temp.next;
        }
        return linkedList;
    }

}
