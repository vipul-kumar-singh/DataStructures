package com.vkstech.algorithms.practice2.linkedlist;

import java.util.StringJoiner;

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
        System.out.println("Flattened List: ");
        flattenList.print();
    }

    private static Node getFlattenList(Node parent) {
        if (parent == null)
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

        if (head1.next != null) {
            head1 = getFlattenList(head1);
        }

        if (head2.next != null) {
            head2 = getFlattenList(head2);
        }

        Node temp = new Node(head1.data);
        Node start = temp;
        head1 = head1.down;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.down = head1;
                head1 = head1.down;
            } else {
                temp.down = head2;
                head2 = head2.down;
            }
            temp = temp.down;
        }

        while (head1 != null) {
            temp.down = head1;
            head1 = head1.down;
            temp = temp.down;
        }

        while (head2 != null) {
            temp.down = head2;
            head2 = head2.down;
            temp = temp.down;
        }

        return start;
    }
}
