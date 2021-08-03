package com.vkstech.algorithms.practice.binarySearchTree;

/**
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:
 * * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * * The left and right subtree each must also be a binary search tree.
 */
public class BinarySearchTree {

    Node root;

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public void insert(int data) {
        root = insertAtNode(root, data);
    }

    public Node insertAtNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data)
            node.left = insertAtNode(node.left, data);
        else
            node.right = insertAtNode(node.right, data);

        return node;
    }

    public void printInOrder() {
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);

        bst.printInOrder();
    }

}
