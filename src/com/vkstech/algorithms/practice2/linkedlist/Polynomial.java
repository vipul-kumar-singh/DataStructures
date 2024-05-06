package com.vkstech.algorithms.practice2.linkedlist;

import java.util.StringJoiner;

public class Polynomial {

    Node head;

    public static class Node {
        int coeff;
        int exp;
        Node next;

        public Node(int coeff, int exp) {
            this.coeff = coeff;
            this.exp = exp;
        }
    }

    public void print() {
        Node temp = this.head;
        StringJoiner sj = new StringJoiner(" + ");
        while (temp != null) {
            sj.add(temp.coeff + "x^" + temp.exp);
            temp = temp.next;
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.head = new Node(1, 3);
        p1.head.next = new Node(2, 2);
        p1.head.next.next = new Node(7, 1);


        Polynomial p2 = new Polynomial();
        p2.head = new Node(3, 4);
        p2.head.next = new Node(4, 2);

        p1.print();
        p2.print();

        Polynomial p3 = addPolynomials(p1, p2);
        p3.print();
    }

    private static Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        if (p1 == null || p1.head == null)
            return p2;

        if (p2 == null || p2.head == null)
            return p1;

        Polynomial p3 = new Polynomial();
        Node p3Node = new Node(-1, -1);
        p3.head = p3Node;

        Node p1Node = p1.head;
        Node p2Node = p2.head;

        while (p1Node != null && p2Node != null) {
            if (p1Node.exp == p2Node.exp) {
                p3Node.next = new Node(p1Node.coeff + p2Node.coeff, p1Node.exp);
                p1Node = p1Node.next;
                p2Node = p2Node.next;
            } else if (p1Node.exp > p2Node.exp) {
                p3Node.next = new Node(p1Node.coeff, p1Node.exp);
                p1Node = p1Node.next;
            } else {
                p3Node.next = new Node(p2Node.coeff, p2Node.exp);
                p2Node = p2Node.next;
            }
            p3Node = p3Node.next;
        }

        while (p1Node != null) {
            p3Node.next = new Node(p1Node.coeff, p1Node.exp);
            p1Node = p1Node.next;
        }

        while (p2Node != null) {
            p3Node.next = new Node(p2Node.coeff, p2Node.exp);
            p2Node = p2Node.next;
        }

        p3.head = p3.head.next;
        return p3;
    }
}