package com.vkstech.algorithms.practice2.linkedlist;

import java.util.Stack;

public class AddOne extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(9, 9, 8);
        System.out.println(linkedList);

        System.out.println("Adding 1");
        addOne(linkedList);
        System.out.println(linkedList);

        System.out.println("Adding 1");
        addOne(linkedList);
        System.out.println(linkedList);

        System.out.println("Adding 1");
        addOne(linkedList);
        System.out.println(linkedList);
    }

    private static void addOne(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        Node temp = linkedList.head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        Stack<Integer> sum = new Stack<>();
        int carry = 1;

        while (!stack.isEmpty()) {
            int n = stack.pop();
            n = n + carry;
            carry = n / 10;
            n = n % 10;
            sum.push(n);
        }

        if (carry > 0) {
            sum.push(carry);
        }

        temp = linkedList.head;
        temp.data = sum.pop();
        while (!sum.empty()) {
            if (temp.next == null) {
                temp.next = new Node(sum.pop());
                temp = temp.next;
            } else {
                temp = temp.next;
                temp.data = sum.pop();
            }
        }
    }
}
