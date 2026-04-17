package com.vkstech.algorithms.practice3.linkedList.circular;

import javafx.util.Pair;

import static com.vkstech.algorithms.practice3.linkedList.circular.MCircularLinkedList.Node;

// https://www.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1
public class TwoHalves {

    public static void main(String[] args) {
        MCircularLinkedList cll1 = new MCircularLinkedList();
        cll1.insert(10);
        cll1.insert(4);
        cll1.insert(9);
        Pair<Node, Node> pair1 = splitList(cll1.head);

        MCircularLinkedList cll1Half1 = new MCircularLinkedList();
        cll1Half1.head = pair1.getKey();
        cll1Half1.print();

        MCircularLinkedList cll1Half2 = new MCircularLinkedList();
        cll1Half2.head = pair1.getValue();
        cll1Half2.print();

        // -----------------------------------------------------------

        MCircularLinkedList cll2 = new MCircularLinkedList();
        cll2.insert(10);
        cll2.insert(4);
        cll2.insert(9);
        cll2.insert(10);
        Pair<Node, Node> pair2 = splitList(cll2.head);

        MCircularLinkedList cll2Half1 = new MCircularLinkedList();
        cll2Half1.head = pair2.getKey();
        cll2Half1.print();

        MCircularLinkedList cll2Half2 = new MCircularLinkedList();
        cll2Half2.head = pair2.getValue();
        cll2Half2.print();

        // -----------------------------------------------------------

        MCircularLinkedList cll3 = new MCircularLinkedList();
        cll3.insert(804);
        cll3.insert(954);

        Pair<Node, Node> pair3 = splitList(cll3.head);

        MCircularLinkedList cll3Half1 = new MCircularLinkedList();
        cll3Half1.head = pair3.getKey();
        cll3Half1.print();

        MCircularLinkedList cll3Half2 = new MCircularLinkedList();
        cll3Half2.head = pair3.getValue();
        cll3Half2.print();
    }

    public static Pair<Node, Node> splitList(Node head) {
        if (head == null) return null;

        if (head == head.next)
            return new Pair<>(head, null);

        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            fast = slow.next;
        }

        Node head2 = slow.next;
        slow.next = head;

        if (fast.next != head) {
            fast = fast.next;
        }

        fast.next = head2;

        return new Pair<>(head, head2);
    }
}
