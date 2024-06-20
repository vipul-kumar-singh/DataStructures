package com.vkstech.algorithms.practice2.heap;

public class MinHeapUsingArray {

    private final int[] heap;
    private int size;
    private final int maxsize;

    private static final int FRONT = 1;

    public MinHeapUsingArray(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;

        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void insert(int element) {
        if (size >= maxsize) {
            System.out.println("Heap is full");
            return;
        }

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeapUsingArray minHeap = new MinHeapUsingArray(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(4);
        minHeap.insert(9);

        minHeap.remove();
        minHeap.remove();

        minHeap.print();
    }
}
