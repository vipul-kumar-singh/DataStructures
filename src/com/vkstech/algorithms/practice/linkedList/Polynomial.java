package com.vkstech.algorithms.practice.linkedList;

import java.util.StringJoiner;

/**
 * Polynomial Addition
 * Given two polynomial numbers represented by a linked list.
 * The task is to adds these lists meaning adds the coefficients who have the same variable powers.
 * Note:  Given polynomials are sorted in decreasing order of power.
 * Input: LinkedList1:  (1,x^3) -> (2,x^2), LinkedList2:  (3,x^3) -> (4,x^2) -> (7,x)
 * Output: 4x^3 + 6x^2 + 7x
 */
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

    public static Polynomial addition(Polynomial p1, Polynomial p2) {
        if (p1 == null || p1.head == null)
            return p2;

        if (p2 == null || p2.head == null)
            return p1;

        Node i = p1.head;
        Node j = p2.head;

        Polynomial sum = new Polynomial();
        Node k = sum.head;

        while (i != null || j != null) {
            Node n;
            if (i == null) {
                n = j;
                j = j.next;
            } else if (j == null) {
                n = i;
                i = i.next;
            } else {
                if (i.exp > j.exp) {
                    n = i;
                    i = i.next;
                } else if (i.exp < j.exp) {
                    n = j;
                    j = j.next;
                } else {
                    n = new Node(i.coeff + j.coeff, i.exp);
                    i = i.next;
                    j = j.next;
                }
            }
            if (k == null){
                sum.head = n;
                k = sum.head;
            }else {
                k.next = n;
                k = k.next;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.head = new Node(1, 3);
        p1.head.next = new Node(2, 2);

        Polynomial p2 = new Polynomial();
        p2.head = new Node(3, 3);
        p2.head.next = new Node(4, 2);
        p2.head.next.next = new Node(7, 1);

        p1.print();
        p2.print();

        Polynomial p3 = addition(p1, p2);
        p3.print();
    }

}