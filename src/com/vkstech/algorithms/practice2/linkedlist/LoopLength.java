package com.vkstech.algorithms.practice2.linkedlist;

public class LoopLength extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(getLoopLength(linkedList));

        Node join = linkedList.head.next.next.next.next;
        Node temp = linkedList.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = join;

        System.out.println(getLoopLength(linkedList));
    }

    public static int getLoopLength(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null) {
            return 0;
        }

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = fast.next;
                int count = 1;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;

            }
        }
        return 0;
    }


}
