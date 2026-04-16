package com.vkstech.algorithms.practice3.linkedList;

class Node {
    int coeff;
    int pow;
    Node next;

    Node(int c, int p) {
        coeff = c;
        pow = p;
        next = null;
    }
}

public class PolynomialAddition {

    public static void main(String[] args) throws Exception {

        // ----------------------------------------------------
        // Example 1 from screenshot:
        // LinkedList1: x^2
        // LinkedList2: x^3
        // Output: x^3 + x^2
        // ----------------------------------------------------
        System.out.println("Example 1:");

        int[] coeff1_ex1 = {1};
        int[] pow1_ex1 = {2};
        Node poly1_ex1 = buildPoly(coeff1_ex1, pow1_ex1);

        int[] coeff2_ex1 = {1};
        int[] pow2_ex1 = {3};
        Node poly2_ex1 = buildPoly(coeff2_ex1, pow2_ex1);

        System.out.print("Polynomial 1: ");
        printPoly(poly1_ex1);

        System.out.print("Polynomial 2: ");
        printPoly(poly2_ex1);

        Node result1 = addPolynomial(poly1_ex1, poly2_ex1);

        System.out.print("Result: ");
        printPoly(result1);

        System.out.println("\n----------------------------------------\n");

        // ----------------------------------------------------
        // Example 2 from screenshot:
        // LinkedList1: x^3 -> 2x^2
        // LinkedList2: 3x^3 -> 4x^2
        // Output: 4x^3 -> 6x^2
        // ----------------------------------------------------
        System.out.println("Example 2:");

        int[] coeff1_ex2 = {1, 2};
        int[] pow1_ex2 = {3, 2};
        Node poly1_ex2 = buildPoly(coeff1_ex2, pow1_ex2);

        int[] coeff2_ex2 = {3, 4};
        int[] pow2_ex2 = {3, 2};
        Node poly2_ex2 = buildPoly(coeff2_ex2, pow2_ex2);

        System.out.print("Polynomial 1: ");
        printPoly(poly1_ex2);

        System.out.print("Polynomial 2: ");
        printPoly(poly2_ex2);

        Node result2 = addPolynomial(poly1_ex2, poly2_ex2);

        System.out.print("Result: ");
        printPoly(result2);
    }

    // Utility to build polynomial from arrays
    public static Node buildPoly(int[] coeff, int[] pow) {
        Node head = null, tail = null;
        for (int i = 0; i < coeff.length; i++) {
            Node temp = new Node(coeff[i], pow[i]);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    // Utility function to print polynomial
    public static void printPoly(Node head) {
        Node curr = head;
        boolean first = true;

        while (curr != null) {
            if (!first) System.out.print(" -> ");
            System.out.print(curr.coeff + "x^" + curr.pow);
            first = false;
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node addPolynomial(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        Node head = null;
        Node temp = head;

        while (temp1 != null && temp2 != null) {
            Node node;

            if (temp1.pow == temp2.pow) {
                node = new Node(temp1.coeff + temp2.coeff, temp1.pow);
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.pow > temp2.pow) {
                node = new Node(temp1.coeff, temp1.pow);
                temp1 = temp1.next;
            } else {
                node = new Node(temp2.coeff, temp2.pow);
                temp2 = temp2.next;
            }


            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }

        while (temp1 != null) {
            Node node = new Node(temp1.coeff, temp1.pow);
            temp1 = temp1.next;

            temp.next = node;
            temp = temp.next;
        }

        while (temp2 != null) {
            Node node = new Node(temp2.coeff, temp2.pow);
            temp2 = temp2.next;

            temp.next = node;
            temp = temp.next;
        }


        return head;
    }
}
