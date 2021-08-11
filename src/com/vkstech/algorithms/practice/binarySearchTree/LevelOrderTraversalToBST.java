package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Convert Level Order Traversal to BST
 * Given an array of size N containing level order traversal of a BST.
 * The task is to complete the function constructBst(), that construct the BST (Binary Search Tree) from its given level order traversal.
 */
public class LevelOrderTraversalToBST extends BinarySearchTree {

    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = constructBST(arr, arr.length);
        PreOrderTraversal.printPreorder(bst);
    }

    public static class NodeDetails {
        Node node;
        int min, max;

        public NodeDetails(Node node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public static Node constructBST(int[] arr, int n) {
        Node root = new Node(arr[0]);
        Queue<NodeDetails> q = new LinkedList<>();

        q.add(new NodeDetails(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int i = 1;
        while (!q.isEmpty()) {
            NodeDetails temp = q.poll();
            Node c = temp.node;
            int min = temp.min;
            int max = temp.max;

            if (i < n && min < arr[i] && arr[i] < c.data) {
                c.left = new Node(arr[i]);
                i++;
                q.add(new NodeDetails(c.left, min, c.data));
            }

            if (i < n && c.data < arr[i] && arr[i] < max) {
                c.right = new Node(arr[i]);
                i++;
                q.add(new NodeDetails(c.right, c.data, max));
            }
        }
        return root;
    }

}
