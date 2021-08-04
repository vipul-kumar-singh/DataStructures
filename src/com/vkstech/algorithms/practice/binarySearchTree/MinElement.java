package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Minimum element in BST
 * Given a Binary Search Tree. The task is to find the minimum element in this given BST.
 */
public class MinElement extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(81, 42, 87, 45, 66, 9).forEach(bst::insert);

        System.out.println(getMin(bst.root));
    }

    public static int getMin(Node node) {
        if (node == null)
            throw new NullPointerException("BST is empty");

        return node.left != null ? getMin(node.left) : node.data;
    }
}
