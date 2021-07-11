package com.vkstech.algorithms.practice.linkedList;

import java.util.StringJoiner;

/**
 * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked-list is in sorted order.
 * Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
 * Note: The flattened list will be printed using the bottom pointer instead of next pointer.
 * Example :
 * Input:
 * 5 -> 10 -> 19 -> 28
 * |     |     |     |
 * 7     20   22    35
 * |           |     |
 * 8          50    40
 * |                 |
 * 30               45
 * Output:  5-> 7-> 8- > 10 -> 19 -> 20-> 22 -> 28 -> 30-> 35-> 40-> 45-> 50.
 */
public class FlattenList {
    Node head;

    public static class Node {
        int data;
        Node next;
        Node down;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertNext(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }

        Node temp = this.head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    public void insertDown(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }

        Node temp = this.head;
        while (temp.down != null)
            temp = temp.down;
        temp.down = node;
    }

    public void print() {
        Node tempNext = this.head;
        StringJoiner sjNext = new StringJoiner("\n");
        while (tempNext != null) {
            Node tempDown = tempNext;
            StringJoiner sjDown = new StringJoiner("->");
            while (tempDown != null) {
                sjDown.add(String.valueOf(tempDown.data));
                tempDown = tempDown.down;
            }
            sjNext.add(sjDown.toString());
            tempNext = tempNext.next;
        }
        System.out.println(sjNext);
    }

    public static void main(String[] args) {
        FlattenList parentList = new FlattenList();

        FlattenList subList1 = new FlattenList();
        subList1.insertDown(5);
        subList1.insertDown(7);
        subList1.insertDown(8);
        subList1.insertDown(30);

        parentList.head = subList1.head;
        Node temp = parentList.head;

        FlattenList subList2 = new FlattenList();
        subList2.insertDown(10);
        subList2.insertDown(20);

        temp.next = subList2.head;
        temp = temp.next;

        FlattenList subList3 = new FlattenList();
        subList3.insertNext(19);
        subList3.insertDown(22);
        subList3.insertDown(50);

        temp.next = subList3.head;
        temp = temp.next;

        FlattenList subList4 = new FlattenList();
        subList4.insertDown(28);
        subList4.insertDown(35);
        subList4.insertDown(40);
        subList4.insertDown(45);

        temp.next = subList4.head;

        parentList.print();

        FlattenList flattenList = new FlattenList();
        flattenList.head = getFlattenList(parentList.head);
        System.out.println("Flattened List :");
        flattenList.print();
    }

    private static Node getFlattenList(Node parent) {
        if (parent == null || parent.next == null)
            return parent;

        Node previous = parent;
        Node mid = parent;
        Node last = parent;

        while (last != null && last.next != null) {
            previous = mid;
            mid = mid.next;
            last = last.next.next;
        }
        previous.next = null;
        return merge(parent, mid);
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        if (head1.next != null)
            head1 = getFlattenList(head1);

        if (head2.next != null)
            head2 = getFlattenList(head2);

        Node i = head1;
        Node j = head2;

        FlattenList mergedList = new FlattenList();
        Node temp = mergedList.head;
        while (i != null || j != null) {
            int data;
            if (i == null) {
                data = j.data;
                j = j.down;
            } else if (j == null) {
                data = i.data;
                i = i.down;
            } else {
                if (i.data < j.data) {
                    data = i.data;
                    i = i.down;
                } else if (i.data > j.data) {
                    data = j.data;
                    j = j.down;
                } else {
                    data = i.data;
                    i = i.down;
                    j = j.down;
                }
            }
            Node node = new Node(data);
            if (temp == null) {
                mergedList.head = node;
                temp = mergedList.head;
            } else {
                temp.down = node;
                temp = temp.down;
            }

        }
        return mergedList.head;
    }
}
