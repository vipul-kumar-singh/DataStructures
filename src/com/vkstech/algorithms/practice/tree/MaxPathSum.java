package com.vkstech.algorithms.practice.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Maximum Path Sum between 2 Leaf Nodes
 * Given a binary tree in which each node element contains a number.
 * Find the maximum possible sum from one leaf node to another leaf node.
 */
public class MaxPathSum extends BinaryTree {

    public static void main(String[] args) {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
           -4   5   6
               / \
              7   8
        */

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.right = new Node(-4);
        binaryTree.root.right.left = new Node(5);
        binaryTree.root.right.right = new Node(6);
        binaryTree.root.right.left.left = new Node(7);
        binaryTree.root.right.left.right = new Node(8);

        System.out.println(findMaxSumPath(binaryTree));
    }

    public static int findMaxSumPath(Node parent, AtomicInteger maxSum) {
        if (parent == null)
            return 0;

        int left = findMaxSumPath(parent.left, maxSum);
        int right = findMaxSumPath(parent.right, maxSum);

        if (parent.left == null)
            return right + parent.data;

        if (parent.right == null)
            return left + parent.data;

        int cur_sum = left + right + parent.data;
        maxSum.set(Math.max(cur_sum, maxSum.get()));

        return Math.max(left, right) + parent.data;
    }

    public static int findMaxSumPath(BinaryTree binaryTree) {
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE);
        findMaxSumPath(binaryTree.root, maxSum);
        return maxSum.get();
    }


}
