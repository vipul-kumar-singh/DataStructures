package com.vkstech.algorithms.practice.linkedList;

import java.util.Stack;

/**
 * Add 1 to a number represented as linked list
 * A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
 * Eg: Input: LinkedList: 4->5->6, Output: 4->5->7
 */
public class AddOne extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(9, 9, 8);
        PrintLinkedList.printLinkedListOneline(linkedList);

        System.out.println("Adding 1");
        addOne(linkedList);
        PrintLinkedList.printLinkedListOneline(linkedList);

        System.out.println("Adding 1");
        addOne(linkedList);
        PrintLinkedList.printLinkedListOneline(linkedList);

        System.out.println("Adding 1");
        addOne(linkedList);
        PrintLinkedList.printLinkedListOneline(linkedList);
    }

    private static void addOne(LinkedList linkedList) {
        if (linkedList == null)
            return;

        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        Node temp = linkedList.head;
        while (temp != null) {
            numStack.push(temp.data);
            temp = temp.next;
        }

        int carry = 1;
        int sum;

        while (!numStack.empty()) {
            sum = numStack.pop() + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            sumStack.push(sum);
        }
        if (carry > 0)
            sumStack.push(carry);

        temp = linkedList.head;
        temp.data = sumStack.pop();
        while(!sumStack.empty()){
            if (temp.next == null){
                temp.next = new Node(sumStack.pop());
                temp = temp.next;
            } else {
                temp = temp.next;
                temp.data = sumStack.pop();
            }
        }
    }
}
