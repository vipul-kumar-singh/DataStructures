package com.vkstech.algorithms.practice3.queue;


public class ProgramExecutor {

    public static void main(String[] args) {
        MLinkedQueue lq = new MLinkedQueue();
        lq.print();

        for (int i = 1; i < 5; i++) {
            lq.enqueue(i);
        }
        lq.print();

        lq.dequeue();
        lq.dequeue();
        lq.print();

        lq.dequeue();
        lq.dequeue();
        lq.print();

        lq.dequeue();
        lq.print();

        System.out.println("-------------------------------------------------");

        MStackedQueue sq = new MStackedQueue();
        sq.print();

        for (int i = 1; i < 5; i++) {
            sq.enqueue(i);
        }
        sq.print();

        sq.dequeue();
        sq.dequeue();
        sq.print();

        sq.dequeue();
        sq.dequeue();
        sq.print();

        sq.dequeue();
        sq.print();

    }
}
