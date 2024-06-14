package com.vkstech.algorithms.practice2.tree;

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

    private static int countNodesInRange(Node node, int min, int max) {
        if (node == null)
            return 0;

        int sum = 0;
        if (node.data >= min && node.data <= max)
            sum++;

        return sum + countNodesInRange(node.left, min, max) + countNodesInRange(node.right, min, max);
    }

}
