package com.vkstech.algorithms.practice.linkedList;

/**
 * Find length of Loop
 * Given a linked list of size N. The task is to that check whether a given Linked List contains a loop or not
 * and if the loop is present then return the count of nodes in a loop or else return 0.
 * Return 0 for no loop.
 * Eg: value[]={25,14,19,33,10,21,39,90,58,45}, The loop is 45->33,
 * Output: 7
 */
public class LoopLength extends LoopDetection {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(25, 14, 19, 33, 10, 21, 39, 90, 58, 45);
        System.out.println(getLoopLength(linkedList));

        Node join =  linkedList.head.next.next.next;
        Node temp = linkedList.head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = join;

        System.out.println(getLoopLength(linkedList));
    }

    private static int getLoopLength(LinkedList linkedList) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        Node joinPoint = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                joinPoint = slow;
                break;
            }
        }

        if (joinPoint == null)
            return 0;

        int length = 1;
        Node temp = joinPoint.next;
        while(temp != joinPoint){
            temp = temp.next;
            length++;
        }
        return length;
    }
}
