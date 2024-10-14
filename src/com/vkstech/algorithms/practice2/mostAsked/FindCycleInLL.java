package com.vkstech.algorithms.practice2.mostAsked;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList;
import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

/**
 * Detect whether a linked list contains a cycle. If a cycle exists, return the node where the cycle begins.
 */
public class FindCycleInLL {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 1; i <= 10; i++)
            ll.insert(i);

        Node pointToJoin = ll.head.next.next.next.next.next;
        Node end = ll.head.next.next.next.next.next.next.next.next.next;
        end.next = pointToJoin;

        System.out.println(findJoiningPoint(ll));
    }

    private static int findJoiningPoint(LinkedList ll) {
        Node slow = ll.head;
        Node fast = ll.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            System.out.println("No Cycle Detected");
            return -1;
        }

        slow = ll.head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}

