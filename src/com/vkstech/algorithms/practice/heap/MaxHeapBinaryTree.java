package com.vkstech.algorithms.practice.heap;

public class MaxHeapBinaryTree extends BinaryHeap<Integer> {

    public MaxHeapBinaryTree() {
        super((a, b) -> a - b);
    }

    public static void main(String[] args) {
        MaxHeapBinaryTree heap = new MaxHeapBinaryTree();
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
