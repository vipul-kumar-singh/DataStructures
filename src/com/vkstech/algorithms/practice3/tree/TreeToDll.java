package com.vkstech.algorithms.practice3.tree;

// https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
public class TreeToDll {

    public static void main(String[] args) {
        Node root = new Node(10);

        Node leftNode = new Node(12);
        Node rightNode = new Node(15);

        leftNode.left = new Node(25);
        leftNode.right = new Node(30);

        rightNode.left = new Node(36);

        root.left = leftNode;
        root.right = rightNode;

        Node dll = bToDLL(root);
        System.out.println(dll.data);
    }

    static class Node {
        int data;
        Node left, right;

        Node() {
            this.data = 0;
            this.left = this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node bToDLL(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        Node dll = new Node();
        createDll(root, dll);
        dll = dll.right;
        dll.left = null;

        return dll;
    }

    private static void createDll(Node node, Node dll) {
        if (node == null) {
            return;
        }

        createDll(node.left, dll);

        Node newNode = new Node(node.data);
        Node temp = dll;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = newNode;
        newNode.left = temp;

        createDll(node.right, dll);
    }
}
