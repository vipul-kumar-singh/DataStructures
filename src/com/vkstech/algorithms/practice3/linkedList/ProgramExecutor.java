package com.vkstech.algorithms.practice3.linkedList;

public class ProgramExecutor {

    public static void main(String[] args) {
        MLinkedList ll = new MLinkedList();
        for (int i = 5; i > 0; i--) {
            ll.insertAtHead(i);
        }

        for (int i = 6; i <= 10; i++) {
            ll.insertAtTail(i);
        }

        ll.print();

        System.out.println(ll.deleteAtHead().data + " deleted");
        System.out.println(ll.deleteAtHead().data + " deleted");

        ll.print();

        System.out.println(ll.deleteAtTail().data + " deleted");
        System.out.println(ll.deleteAtTail().data + " deleted");

        ll.print();
    }
}
