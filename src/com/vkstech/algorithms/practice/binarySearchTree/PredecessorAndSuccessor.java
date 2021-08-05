package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Predecessor and Successor
 * There is BST given with root node with key part as integer only.
 * You need to find the inorder successor and predecessor of a given key.
 * In case, if the either of predecessor or successor is not found print -1.
 */
public class PredecessorAndSuccessor extends BinarySearchTree {

    private static Node pre = new Node(-1);
    private static Node suc = new Node(-1);

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(50, 30, 30, 20, 30, 40, 50, 70, 70, 60, 70, 80).forEach(bst::insert);

        printPrintPreSuc(bst, 65);
        printPrintPreSuc(bst, 100);
    }

    private static void printPrintPreSuc(BinarySearchTree bst, int data) {
        pre.data = -1;
        suc.data = -1;
        findPreSuc(bst.root, data);
        System.out.println("Predecessor: " + pre.data);
        System.out.println("Successor: " + suc.data);
    }

    private static void findPreSuc(Node root, int key) {
        if (root == null)
            return;

        if (root.data == key) {
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;
                pre = tmp;
            }

            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null)
                    tmp = tmp.left;
                suc = tmp;
            }

            return;
        }

        if (root.data > key) {
            suc = root;
            findPreSuc(root.left, key);
        } else {
            pre = root;
            findPreSuc(root.right, key);
        }
    }
}
