package com.vkstech.algorithms.practice2.linkedlist;

public class LoopRemove extends LoopDetection {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(25, 14, 19, 33, 10, 21, 39, 90, 58, 45);

        Node join = linkedList.head.next.next.next;
        Node temp = linkedList.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = join;
        System.out.println(checkLoop(linkedList));

        removeLoop(linkedList);
        System.out.println(checkLoop(linkedList));
        System.out.println(linkedList);

    }

    private static void removeLoop(LinkedList linkedList) {
        if (linkedList == null) {
            return;
        }

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow == fast) {
            slow = linkedList.head;

            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            } else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            }
            fast.next = null;
        }


    }

}
