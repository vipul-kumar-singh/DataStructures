package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
public class Addition {

    public static void main(String[] args) {
        MLinkedList num1 = new MLinkedList();
        num1.insertMultiple(1, 2, 3);

        MLinkedList num2 = new MLinkedList();
        num2.insertMultiple(9, 9, 9);

        MLinkedList sum1 = new MLinkedList();
        sum1.head = addTwoLists(num1.head, num2.head);
        sum1.print();


        MLinkedList num3 = new MLinkedList();
        num3.insertMultiple(4, 5);

        MLinkedList num4 = new MLinkedList();
        num4.insertMultiple(3, 4, 5);

        MLinkedList sum2 = new MLinkedList();
        sum2.head = addTwoLists(num3.head, num4.head);
        sum2.print();


        MLinkedList num5 = new MLinkedList();
        num5.insertMultiple(0, 0, 0, 2, 3, 7, 1);

        MLinkedList num6 = new MLinkedList();
        num6.insertMultiple(0, 0, 3, 1, 1, 2);

        MLinkedList sum3 = new MLinkedList();
        sum3.head = addTwoLists(num5.head, num6.head);
        sum3.print();


        MLinkedList num7 = new MLinkedList();
        num7.insertMultiple(2, 6, 7, 3, 8, 9, 8);

        MLinkedList num8 = new MLinkedList();
        num8.insertMultiple(0, 0);

        MLinkedList sum4 = new MLinkedList();
        sum4.head = addTwoLists(num7.head, num8.head);
        sum4.print();
    }

    public static Node addTwoLists(Node head1, Node head2) {
        head1 = removeLeadingZeroes(head1);
        head2 = removeLeadingZeroes(head2);

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node rev1 = reverse(head1);
        Node rev2 = reverse(head2);

        int carry = 0;

        Node result = null;
        Node temp = result;

        while (rev1 != null && rev2 != null) {
            int sum = rev1.data + rev2.data + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            rev1 = rev1.next;
            rev2 = rev2.next;

            Node node = new Node(sum);
            if (temp == null) {
                result = node;
                temp = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }

        while (rev1 != null) {
            int sum = carry != 0 ? carry + rev1.data : rev1.data;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            Node node = new Node(sum);
            temp.next = node;
            temp = temp.next;
            rev1 = rev1.next;
        }

        while (rev2 != null) {
            int sum = carry != 0 ? carry + rev2.data : rev2.data;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            Node node = new Node(sum);
            temp.next = node;
            temp = temp.next;
            rev2 = rev2.next;
        }

        if (carry != 0) {
            temp.next = new Node(carry);
        }

        return reverse(result);
    }

    private static Node removeLeadingZeroes(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }

        return head;
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
