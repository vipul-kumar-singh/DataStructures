package com.vkstech.algorithms.practice.binarySearchTree;

public class PreOrderTraversal extends BinarySearchTree{

    public static void printPreorder(BinarySearchTree bst) {
        preorder(bst.root);
        System.out.println();
    }

    private static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

}
