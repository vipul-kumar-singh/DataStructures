package com.vkstech.algorithms.practice.linkedList;

/**
 * Given a linked list of 0s, 1s and 2s, sort it.
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only.
 * The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side,
 * 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
 * Example : Input = 1->2->2->1->2->0->2->2
 * Output: 0->1->1->2->2->2->2->2
 */
public class Sort012 extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(1, 2, 2, 1, 2, 0, 2, 2);
        PrintLinkedList.printLinkedListOneline(linkedList);

        segregate(linkedList);
        PrintLinkedList.printLinkedListOneline(linkedList);
    }

    private static void segregate(LinkedList linkedList) {
        Node temp = linkedList.head;
        int[] countArr = new int[3];
        while (temp != null) {
            countArr[temp.data]++;
            temp = temp.next;
        }

        temp = linkedList.head;
        int index = 0;
        while (temp != null) {
            if (countArr[index]-- > 0) {
                temp.data = index;
                temp = temp.next;
            }else {
                index++;
            }

        }
    }
}
