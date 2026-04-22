package com.vkstech.algorithms.practice3.tree;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;


//https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        MBinaryTree binaryTree1 = new MBinaryTree();
        binaryTree1.insertLevelOrder(1, 2, 3);
        System.out.println(getDiameter(binaryTree1.root));

        MBinaryTree binaryTree2 = new MBinaryTree();
        binaryTree2.insertLevelOrder(5, 8, 6, 3, 7, 9);
        System.out.println(getDiameter(binaryTree2.root));
    }

    private static int getDiameter(Node root) {
        if (root == null)
            return 0;

        int lHeight = nodeHeight(root.left);
        int rHeight = nodeHeight(root.right);

        int lDiameter = getDiameter(root.left);
        int rDiameter = getDiameter(root.right);

        return Math.max(lHeight + rHeight,
                Math.max(lDiameter, rDiameter));
    }

    private static int nodeHeight(Node node) {
        return node == null ? 0 :
                Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
    }


}
