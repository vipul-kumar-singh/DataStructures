package com.vkstech.algorithms.practice2.heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryHeap {

    Node root;
    Comparator<Integer> comparator;

    public static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public BinaryHeap(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node node = new Node(data);

        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp.left == null) {
                node.parent = temp;
                temp.left = node;
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                node.parent = temp;
                temp.right = node;
                break;
            } else {
                queue.add(temp.right);
            }
        }

        heapifyUp(node);
    }

    private void heapifyUp(Node node) {
        if (node.parent != null && comparator.compare(node.data, node.parent.data) > 0) {
            swap(node, node.parent);
            heapifyUp(node.parent);
        }
    }

    private void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap((a, b) -> a - b);
        binaryHeap.insert(3);
        binaryHeap.insert(4);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
    }
}
