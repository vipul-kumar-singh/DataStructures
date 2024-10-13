package com.vkstech.algorithms.practice2.tree;

public class FixingBST extends BinarySearchTree {

    private static Node first;
    private static Node middle;
    private static Node last;
    private static Node prev;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(10);
        bst.root.left = new Node(5);
        bst.root.right = new Node(8);
        bst.root.left.left = new Node(2);
        bst.root.left.right = new Node(20);
        BinaryTreeTraversal.inOrder(bst.root);
        System.out.println();

        correctBST(bst.root);
        BinaryTreeTraversal.inOrder(bst.root);
        System.out.println();
    }

    public static void correctBSTUtil(Node root) {
        if (root != null) {
            correctBSTUtil(root.left);

            if (prev != null && root.data < prev.data) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }

            prev = root;
            correctBSTUtil(root.right);
        }
    }

    private static void correctBST(Node root) {
        first = middle = last = prev = null;
        correctBSTUtil(root);

        if (first != null) {
            if (last != null)
                swap(first, last);
            else if (middle != null)
                swap(first, middle);
        }

    }

    private static void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}
