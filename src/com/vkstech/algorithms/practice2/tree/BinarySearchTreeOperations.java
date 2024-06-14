package com.vkstech.algorithms.practice2.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTreeOperations extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(15);
        bst.insert(19);
        bst.insert(35);
        bst.insert(16);
        bst.insert(4);
        bst.insert(10);
        bst.insert(6);

        System.out.println(getMin(bst.root));

        int[] inOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTree bst1 = getBstFromArray(inOrder);
        BinaryTreeTraversal.inOrder(bst1.root);
        System.out.println();

        System.out.println("Nodes in range: " + countNodesInRange(bst.root, 8, 18));

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(50);
        bst2.insert(30);
        bst2.insert(70);
        bst2.insert(20);
        bst2.insert(40);
        bst2.insert(60);
        bst2.insert(80);
        addAllGreaterValues(bst2.root);
        BinaryTreeTraversal.inOrder(bst2.root);
        System.out.println();

    }

    public static int getMin(Node node) {
        if (node == null)
            return -1;

        if (node.left == null)
            return node.data;

        return getMin(node.left);
    }

    public static BinarySearchTree getBstFromArray(int[] arr) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = getBstFromArray(arr, 0, arr.length);
        return bst;
    }

    private static Node getBstFromArray(int[] arr, int start, int end) {
        if (start >= end)
            return null;

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = getBstFromArray(arr, start, mid);
        node.right = getBstFromArray(arr, mid + 1, end);
        return node;
    }

    public static int countNodesInRange(Node node, int min, int max) {
        if (node == null)
            return 0;

        int sum = 0;
        if (node.data >= min && node.data <= max)
            sum++;

        return sum + countNodesInRange(node.left, min, max) + countNodesInRange(node.right, min, max);
    }

    public static void addAllGreaterValues(Node node) {
        addAllGreaterValues(node, new AtomicInteger());
    }

    public static void addAllGreaterValues(Node node, AtomicInteger sum) {
        if (node == null)
            return;

        addAllGreaterValues(node.right, sum);

        sum.set(sum.get() + node.data);
        node.data = sum.get();

        addAllGreaterValues(node.left, sum);
    }

}
