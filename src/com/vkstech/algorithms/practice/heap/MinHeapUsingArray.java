package com.vkstech.algorithms.practice.heap;

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

    public MinHeapUsingArray(int... heapElements) {
        this.maxsize = heapElements.length;
        this.size = this.maxsize;

        heap = new int[heapElements.length + 1];
        heap[0] = Integer.MIN_VALUE;

        System.arraycopy(heapElements, 0, heap, 1, heap.length - 1);
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fPos, int sPos) {
        int tmp;
        tmp = heap[fPos];

        heap[fPos] = heap[sPos];
        heap[sPos] = tmp;
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

    public void insert(int element) {
        if (size >= maxsize)
            return;

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
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

    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private int getHeight() {
        return (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");

        MinHeapUsingArray minHeap = new MinHeapUsingArray(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Height of tree is " + minHeap.getHeight());
    }
}
