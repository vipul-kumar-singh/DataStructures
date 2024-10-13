package com.vkstech.algorithms.practice2.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree {
    Node root;

    public static class Node {
        int data;
        Node next;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private void connectNodes() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            Node previous = null;

            for (int i = 0; i < n; i++) {
                Node curr = queue.remove();

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);

                if (previous != null)
                    previous.next = curr;

                previous = curr;
            }
        }
    }

    public static void main(String[] args) {
        Node leftNode = new Node(3);
        leftNode.left = new Node(4);
        leftNode.right = new Node(1);

        Node rightNode = new Node(5);
        rightNode.right = new Node(2);

        Node root = new Node(10);
        root.left = leftNode;
        root.right = rightNode;

        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
        linkedBinaryTree.root = root;

        linkedBinaryTree.connectNodes();
        System.out.println();
    }
}
