package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Normal BST to Balanced BST
 * Given a Binary Search Tree, modify the given BST such that itis balanced and has minimum possible height.
 */
public class BstToBalancedBst extends BinarySearchTree {

    private static final Queue<Integer> inOrderQueue = new LinkedList<>();

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(4, 3, 2, 1).forEach(bst::insert);
        PreOrderTraversal.printPreorder(bst);

        bst.root = balanceBst(bst);
        PreOrderTraversal.printPreorder(bst);
    }

    private static Node balanceBst(BinarySearchTree bst) {
        inOrder(bst.root);
        int[] inArr = new int[inOrderQueue.size()];

        int i = 0;
        while (!inOrderQueue.isEmpty())
            inArr[i++] = inOrderQueue.remove();

        return SortedArrayToBalancedBST.sortedArrayToBST(inArr, 0, inArr.length - 1);
    }

    private static void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        inOrderQueue.add(node.data);
        inOrder(node.right);
    }
}
