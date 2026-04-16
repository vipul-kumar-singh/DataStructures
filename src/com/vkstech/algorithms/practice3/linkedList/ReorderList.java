package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/reorder-list/1
public class ReorderList {

    public static void main(String[] args) {
        MLinkedList list1 = new MLinkedList();
        list1.insertMultiple(1, 2, 3, 4, 5);
        reorderlist(list1.head);
        list1.print();

        MLinkedList list2 = new MLinkedList();
        list2.insertMultiple(1, 7, 3, 4);
        reorderlist(list2.head);
        list2.print();

        MLinkedList list3 = new MLinkedList();
        list3.insertMultiple(1);
        reorderlist(list3.head);
        list3.print();
    }

    public static void reorderlist(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rev = reverse(slow.next);
        slow.next = null;

        Node temp = head;

        while (rev != null) {
            Node next = temp.next;
            temp.next = rev;
            temp = temp.next;
            rev = rev.next;
            temp.next = next;
            temp = temp.next;
        }
    }

    private static Node reverse(Node head) {
        Node start = null;
        Node temp = head;

        while (temp != null) {
            Node node = new Node(temp.data);

            if (start != null) {
                node.next = start;
            }
            start = node;

            temp = temp.next;
        }

        return start;
    }
}
