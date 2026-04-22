package com.vkstech.algorithms.practice3.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MBinaryTree {

    Node root;
    public static final Integer N = -1;

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertLevelOrder(int... arr) {
        root = build(arr, 0);
    }

    private Node build(int[] arr, int i) {
        if (i >= arr.length || arr[i] == -1) {
            return null;
        }

        Node node = new Node(arr[i]);
        node.left = build(arr, 2 * i + 1);
        node.right = build(arr, 2 * i + 2);

        return node;
    }

    public void printInorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void printPreorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        inorder(node.left);
        inorder(node.right);
    }

    public void printPostorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public void printLevelOrder() {
        levelOrder(root);
        System.out.println();
    }

    private void levelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            node = q.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }

    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
