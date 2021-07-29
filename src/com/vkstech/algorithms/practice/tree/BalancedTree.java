package com.vkstech.algorithms.practice.tree;

/**
 *  Check for Balanced Tree
 *  Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left and right subtrees
 * is not more than one for all nodes of tree.
 */
public class BalancedTree extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LevelOrderInsertion.insert(binaryTree, 10);
        LevelOrderInsertion.insert(binaryTree, 20);
        LevelOrderInsertion.insert(binaryTree, 30);
        LevelOrderInsertion.insert(binaryTree, 40);
        LevelOrderInsertion.insert(binaryTree, 60);

        System.out.println(checkBalancedHeight(binaryTree.root));

    }

    private static boolean checkBalancedHeight(Node node) {
        int lHeight;
        int rHeight;

        if (node == null)
            return true;

        lHeight = getHeight(node.left);
        rHeight = getHeight(node.right);

        return Math.abs(lHeight - rHeight) <= 1
                && checkBalancedHeight(node.left)
                && checkBalancedHeight(node.right);
    }

    private static int getHeight(Node node) {
        if (node == null)
            return -1;

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }
}
