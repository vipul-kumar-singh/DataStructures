package com.vkstech.algorithms.practice3.linkedList.doubly;

public class ProgramExecutor {

    public static void main(String[] args) {
        MDoublyLinkedList ll = new MDoublyLinkedList();
        for (int i = 5; i > 0; i--) {
            ll.insertAtHead(i);
        }

        for (int i = 6; i <= 10; i++) {
            ll.insertAtTail(i);
        }

        System.out.println(ll.deleteAtTail().data + " deleted");
        System.out.println(ll.deleteAtTail().data + " deleted");

        ll.print();
    }
}
