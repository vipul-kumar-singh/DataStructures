package com.vkstech.algorithms.practice.tree;

import java.util.stream.IntStream;

/**
 * Diameter of Binary Tree
 * Given a Binary Tree, find diameter of it.
 * The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree.
 * The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded
 * (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 */
public class DiameterOfBinaryTree extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 8).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        System.out.println(getDiameter(binaryTree.root));
    }

    private static int getDiameter(Node root) {
        if (root == null)
            return 0;

        int lHeight = nodeHeight(root.left);
        int rHeight = nodeHeight(root.right);

        int lDiameter = getDiameter(root.left);
        int rDiameter = getDiameter(root.right);

        return Math.max(lHeight + rHeight + 1,
                Math.max(lDiameter, rDiameter));
    }

    private static int nodeHeight(Node node) {
        return node == null ? 0 :
                Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
    }


}
