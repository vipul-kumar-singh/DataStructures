package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;

/**
 * Count BST nodes that lie in a given range
 * Given a BST and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
 * The values smaller than root go to the left side
 * The values greater and equal to the root go to the right side
 */
public class CountNodesInRange extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(10, 5, 50, 1, 40, 100).forEach(bst::insert);

        System.out.println(countNodes(bst.root, 5, 45));
        System.out.println(countNodes(bst.root, 5, 50));
        System.out.println(countNodes(bst.root, 1, 100));
        System.out.println(countNodes(bst.root, 101, 110));
    }

    private static int countNodes(Node node, int l, int r) {
        if (node == null)
            return 0;

        if (node.data > r)
            return countNodes(node.left, l, r);

        if (node.data < l)
            return countNodes(node.right, l, r);

        return 1 + countNodes(node.left, l, r) + countNodes(node.right, l, r);

    }
}
