package com.vkstech.algorithms.practice3.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class MBinarySearchTree {

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

    public void insert(int... data) {
        for (int i : data) {
            root = insert(root, i);
        }
    }

    public Node insert(Node root, int key) {
        Node node = new Node(key);

        if (root == null) {
            root = node;
            return root;
        }

        if (key < root.data) {
            if (root.left != null) {
                insert(root.left, key);
            } else {
                root.left = node;
            }
        }

        if (key >= root.data) {
            if (root.right != null) {
                insert(root.right, key);
            } else {
                root.right = node;
            }
        }
        return root;
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

    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.data) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public Node delNode(Node root, int x) {
        if (root == null) return root;

        if (root.data > x) {
            root.left = delNode(root.left, x);
        } else if (root.data < x) {
            root.right = delNode(root.right, x);
        } else {
            // Node with 0 or 1 child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with 2 children
            Node succ = getSuccessor(root);
            root.data = succ.data;
            root.right = delNode(root.right, succ.data);
        }
        return root;
    }

    private static Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
