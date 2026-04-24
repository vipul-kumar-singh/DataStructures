package com.vkstech.algorithms.practice3.heap;

public class ProgramExecutor {

    public static void main(String[] args) {

        MHeap heap = new MHeap((a, b) -> b - a);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        heap.insert(1);

        System.out.println(heap.root.data);
    }
}
