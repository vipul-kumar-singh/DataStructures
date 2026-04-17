package com.vkstech.algorithms.practice3.linkedList.circular;

public class ProgramExecutor {

    public static void main(String[] args) {
        MCircularLinkedList cll = new MCircularLinkedList();
        cll.print();

        for (int i = 1; i <= 5; i++) {
            cll.insert(i);
            System.out.println("Inserted " + i);
            cll.print();
        }

        System.out.println(cll.delete().data + " deleted");
        System.out.println(cll.delete().data + " deleted");

        cll.print();

        System.out.println(cll.delete().data + " deleted");
        System.out.println(cll.delete().data + " deleted");

        cll.print();

        System.out.println(cll.delete().data + " deleted");
        cll.print();

        System.out.println(cll.delete().data + " deleted");
    }
}
