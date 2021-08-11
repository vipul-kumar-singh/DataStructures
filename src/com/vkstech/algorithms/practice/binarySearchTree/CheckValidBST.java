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

        System.out.println(isValidBst(bst.root));

        bst.root.right.right.right = new Node(0);
        System.out.println(isValidBst(bst.root));
    }

    private static boolean isValidBst(Node node) {
        if (node == null)
            return true;

        if (node.left != null && node.left.data > node.data)
            return false;

        if (node.right != null && node.right.data < node.data)
            return false;

        return isValidBst(node.left) && isValidBst(node.right);
    }
}
