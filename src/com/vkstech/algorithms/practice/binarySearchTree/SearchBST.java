package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Search a node in BST
 * Given a Binary Search Tree and a node value X, find if node with value X is present in the BST or not.
 */
public class SearchBST extends BinarySearchTree {

    public static void main(String[] args) {
        SearchBST searchBST = new SearchBST();
        Arrays.asList(2, 81, 42, 87, 45, 66, 90).forEach(searchBST::insert);

        System.out.println(searchBST.isPresent(87));
        System.out.println(searchBST.isPresent(2));
        System.out.println(searchBST.isPresent(90));
        System.out.println(searchBST.isPresent(91));
    }

    private boolean isPresent(int data) {
        return search(this.root, data);
    }

    public boolean search(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        return data < node.data ? search(node.left, data) : search(node.right, data);
    }
}
