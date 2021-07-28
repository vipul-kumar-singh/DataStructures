package com.vkstech.algorithms.practice.tree;

/**
 * Children Sum Parent
 * Given a Binary Tree, check whether all of its nodes have the value equal to the sum of their child nodes.
 */
public class ChildrenSumParent extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LevelOrderInsertion.insert(binaryTree, 10);
        LevelOrderInsertion.insert(binaryTree, 5);
        LevelOrderInsertion.insert(binaryTree, 5);
        LevelOrderInsertion.insert(binaryTree, 3);
        LevelOrderInsertion.insert(binaryTree, 2);

        System.out.println(checkIfBalanced(binaryTree.root));

    }

    private static boolean checkIfBalanced(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return true;

        int curSum = 0;

        if (node.left != null)
            curSum += node.left.data;

        if (node.right != null)
            curSum += node.right.data;

        boolean leftFlag = checkIfBalanced(node.left);
        boolean rightFlag = checkIfBalanced(node.right);
        return (curSum == node.data) && leftFlag && rightFlag;
    }
}
