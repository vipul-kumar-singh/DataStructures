package com.vkstech.algorithms.practice2.tree;

public class BinarySearchTree extends BinaryTree {

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);

        return node;

    }

    public static boolean isPresent(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        return isPresent(data < node.data ? node.left : node.right, data);

    }

    public void delete(int key) {
        this.root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null)
            return node;

        if (node.data > key) {
            node.left = delete(node.left, key);
            return node;
        }

        if (node.data < key) {
            node.right = delete(node.right, key);
            return node;
        }

        // If left child is empty
        if (node.left == null) {
            return node.right;
        }

        // If right child is empty
        if (node.right == null) {
            return node.left;
        }

        // If both children exists
        Node parent = node;
        Node next = node.right;

        while (next.left != null) {
            parent = next;
            next = next.left;
        }

        if (parent != node)
            parent.left = next.right;
        else
            parent.right = next.right;

        node.data = next.data;
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);

        BinaryTreeTraversal.inOrder(bst.root);
        System.out.println();
        System.out.println(isPresent(bst.root, 2));
        System.out.println(isPresent(bst.root, 5));

        bst.delete(2);
        BinaryTreeTraversal.inOrder(bst.root);
        System.out.println();

        bst.delete(3);
        BinaryTreeTraversal.inOrder(bst.root);
        System.out.println();
    }
}
