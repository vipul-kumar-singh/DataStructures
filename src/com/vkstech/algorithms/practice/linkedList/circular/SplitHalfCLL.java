package com.vkstech.algorithms.practice.linkedList.circular;

/**
 * Split a Circular Linked List into two halves.
 * Given a Circular Linked List of size N, split it into two halves circular lists.
 * If there are odd number of nodes in the given circular linked list then out of the resulting two halved lists,
 * first list should have one node more than the second list.
 * The resultant lists should also be circular lists and not linear lists.
 * Input: Circular LinkedList: 1->5->7
 * Output: 1 and 5<->7
 */
public class SplitHalfCLL extends CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList(1, 5, 7);
        cll.print();

        splitInHalf(cll);
    }

    private static void splitInHalf(CircularLinkedList cll) {
        if (cll.head == cll.head.next)
            return;

        Node slow = cll.head;
        Node fast = cll.head;

        while (fast.next != cll.head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        CircularLinkedList firstHalf = new CircularLinkedList();
        fillLinkedList(firstHalf, cll.head, slow);

        CircularLinkedList secondHalf = new CircularLinkedList();
        fillLinkedList(secondHalf, slow, cll.head);

        System.out.println("First Half : ");
        firstHalf.print();
        System.out.println("Second Half : ");
        secondHalf.print();
    }

    private static void fillLinkedList(CircularLinkedList circularLinkedList, Node start, Node end) {
        Node index = circularLinkedList.head;

        Node temp = start;
        while (temp != end) {
            Node node = new Node(temp.data);
            if (index == null) {
                circularLinkedList.head = node;
                index = circularLinkedList.head;
            } else {
                index.next = node;
                index = index.next;
            }
            temp = temp.next;
        }
    }
}
