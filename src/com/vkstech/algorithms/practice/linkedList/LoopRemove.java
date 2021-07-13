package com.vkstech.algorithms.practice.linkedList;

/**
 * Remove loop in Linked List
 * Remove the loop from the linked list, if it is present.
 */
public class LoopRemove extends LoopDetection {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(25, 14, 19, 33, 10, 21, 39, 90, 58, 45);

        Node join = linkedList.head;
        Node temp = linkedList.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = join;
        System.out.println(checkLoop(linkedList));

        removeLoop(linkedList);
        System.out.println(checkLoop(linkedList));
        PrintLinkedList.printLinkedListOneline(linkedList);

    }

    private static void removeLoop(LinkedList linkedList) {
        if (linkedList == null)
            return;

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
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
