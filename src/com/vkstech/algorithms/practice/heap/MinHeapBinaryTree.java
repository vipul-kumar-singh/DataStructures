package com.vkstech.algorithms.practice.heap;

public class MinHeapBinaryTree extends BinaryHeap<Integer> {

    public MinHeapBinaryTree() {
        super((a, b) -> b - a);
    }

    public static void main(String[] args) {
        MinHeapBinaryTree heap = new MinHeapBinaryTree();
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        System.out.println(heap.getTop());
        heap.insert(4);
        heap.delete();
        System.out.println(heap.getTop());
        heap.insert(6);
        heap.insert(5);
        System.out.println(heap.getTop());
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        System.out.println(heap.getTop());
        heap.delete();
        System.out.println(heap.getTop());
    }

}
