package com.vkstech.algorithms.practice.linkedList;

/**
 * Detect Loop in linked list
 * Given a linked list of N nodes. The task is to check if the linked list has a loop.
 * Linked list can contain self loop.
 */
public class LoopDetection extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(checkLoop(linkedList));

        Node join = linkedList.head.next.next.next.next;
        Node temp = linkedList.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = join;

        System.out.println(checkLoop(linkedList));
    }

    private static boolean checkLoop(LinkedList linkedList) {
        if (linkedList == null)
            return true;

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
