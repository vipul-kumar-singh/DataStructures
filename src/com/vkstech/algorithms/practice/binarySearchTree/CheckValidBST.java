package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Check for BST
 * Given a binary tree. Check whether it is a BST or not.
 * Note: We are considering that BSTs can not contain duplicate Nodes.
 */
public class CheckValidBST extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(5, 4, 6, 1, 2, 9).forEach(bst::insert);

        System.out.println(isValidBst(bst));

        bst.root.right.right.left = new Node(1);
        System.out.println(isValidBst(bst));
    }

    public static boolean isValidBst(BinarySearchTree bst) {
        return isBst(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBst(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        return (isBst(node.left, min, node.data - 1) && isBst(node.right, node.data + 1, max));
    }
}
