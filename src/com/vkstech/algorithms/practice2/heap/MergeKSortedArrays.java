package com.vkstech.algorithms.practice2.heap;

import java.util.Arrays;

public class MergeKSortedArrays extends MinHeap {

    public static void main(String... args) {
        int[][] arr = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeKSortedArrays(arr);
    }

    public MergeKSortedArrays(Node[] arr) {
        super(arr);
    }

    public static void mergeKSortedArrays(int[][] arr) {
        int n = arr.length;
        Node[] hArr = new Node[n];
        int resultSize = 0;
        for (int i = 0; i < n; i++) {
            Node node = new Node(arr[i][0], i, 1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }

        MinHeap mh = new MinHeap(hArr);

        int[] result = new int[resultSize];

        for (int i = 0; i < resultSize; i++) {
            Node node = mh.getMin();
            result[i] = node.data;

            if (node.j < arr[node.i].length)
                node.data = arr[node.i][node.j++];
            else
                node.data = Integer.MAX_VALUE;

            mh.replaceMin(node);
        }

        System.out.println(Arrays.toString(result));
    }

}

class MinHeap {
    Node[] heap;
    int size;

    public static class Node {
        int data;
        int i;
        int j;

        public Node(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }

    public MinHeap(Node[] arr) {
        this.heap = arr;
        size = arr.length;
        int i = (size - 1) / 2;
        while (i >= 0) {
            minHeapify(i);
            i--;
        }
    }

    private int leftChild(int pos) {
        return (2 * pos + 1);
    }

    private int rightChild(int pos) {
        return (2 * pos + 2);
    }

    public void minHeapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);

        int min = pos;

        if (left < size &&
                heap[left].data < heap[pos].data)
            min = left;

        if (right < size
                && heap[right].data < heap[min].data)
            min = right;

        if (min != pos) {
            swap(heap, pos, min);
            minHeapify(min);
        }
    }

    public void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public Node getMin() {
        if (size <= 0) {
            System.out.println("Heap underflow");
            return null;
        }
        return heap[0];
    }

    void replaceMin(Node node) {
        heap[0] = node;
        minHeapify(0);
    }
}