package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Delete a node from BST
 * Given a Binary Search Tree and a node value X. Delete the node with the given value X from the BST.
 * If no node with value x exists, then do not make any change.
 */
public class DeleteBST extends BinarySearchTree {

    public static void main(String[] args) {
        DeleteBST bst = new DeleteBST();
        Arrays.asList(1, 2, 8, 5, 11, 4, 7, 9, 12).forEach(bst::insert);
        bst.printInOrder();

        bst.delete(9);
        bst.printInOrder();

    }

    public void delete(int data) {
        this.root = deleteNode(root, data);
    }

    static Node deleteNode(Node node, int k) {
        if (node == null)
            return node;

        if (node.data > k) {
            node.left = deleteNode(node.left, k);
            return node;
        }

        if (node.data < k) {
            node.right = deleteNode(node.right, k);
            return node;
        }

        // If left child is empty
        if (node.left == null) {
            return node.right;
        }

        // If right child is empty
        if (node.right == null) {
            return node.left;
        }

        // If both children exist
        Node parent = node;
        Node next = node.right;

        while (next.left != null) {
            parent = next;
            next = next.left;
        }

        if (parent != node)
            parent.left = next.right;
        else
            parent.right = next.right;

        node.data = next.data;
        return node;
    }
}
