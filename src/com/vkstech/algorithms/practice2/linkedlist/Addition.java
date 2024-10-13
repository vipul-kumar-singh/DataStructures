package com.vkstech.algorithms.practice2.linkedlist;

public class Addition extends LinkedList {

    public static void main(String[] args) {
        LinkedList num1 = new LinkedList();
        num1.insertMultiple(4, 5, 0);

        LinkedList num2 = new LinkedList();
        num2.insertMultiple(4, 5);

        LinkedList result = addNums(num1, num2);
        System.out.println(result);
    }

    private static LinkedList addNums(LinkedList num1, LinkedList num2) {
        if (num1.head == null && num2.head == null)
            return null;

        if (num1.head == null)
            return num2;

        if (num2.head == null)
            return num1;


        int n1 = 0, n2 = 0;

        Node temp = num1.head;
        while (temp != null) {
            n1 = (n1 * 10) + temp.data;
            temp = temp.next;
        }

        temp = num2.head;
        while (temp != null) {
            n2 = (n2 * 10) + temp.data;
            temp = temp.next;
        }

        int sum = n1 + n2;

        LinkedList result = new LinkedList();
        while (sum != 0) {
            int i = sum % 10;
            if (result.head == null) {
                result.head = new Node(i);
            } else {
                Node newNode = new Node(i);
                newNode.next = result.head;
                result.head = newNode;
            }
            sum = sum / 10;
        }

        return result;
    }
}
