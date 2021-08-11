package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Closest Neighbor in BST
 * Given a binary search tree and a number N, find the number in the binary search tree that is close to N.
 */
public class ClosestNeighbour extends BinarySearchTree {

    private static int minDiff;
    private static int minDiffData;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(5, 2, 12, 1, 3, 9, 21, 19, 25).forEach(bst::insert);

        System.out.println(maxDiff(bst.root, 24));
        System.out.println(maxDiff(bst.root, 4));
    }

    public static int maxDiff(Node root, int k) {
        minDiff = Integer.MAX_VALUE;
        minDiffData = -1;
        maxDiffUtil(root, k);
        return minDiffData;
    }

    private static void maxDiffUtil(Node node, int data) {
        if (node == null)
            return;

        if (node.data == data) {
            minDiffData = data;
            return;
        }

        if (minDiff > Math.abs(node.data - data)) {
            minDiff = Math.abs(node.data - data);
            minDiffData = node.data;
        }

        maxDiffUtil(data < node.data ? node.left : node.right, data);
    }

}
