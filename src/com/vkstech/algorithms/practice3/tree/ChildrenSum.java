package com.vkstech.algorithms.practice3.tree;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

// https://www.geeksforgeeks.org/problems/children-sum-parent/1
public class ChildrenSum {

    public static void main(String[] args) {
        MBinaryTree tree1 = new MBinaryTree();
        tree1.insertLevelOrder(35, 20, 15, 15, 5, 10, 5);
        System.out.println(isSumProperty(tree1.root));

        MBinaryTree tree2 = new MBinaryTree();
        tree2.insertLevelOrder(1, 4, 3, 5);
        System.out.println(isSumProperty(tree2.root));
    }

    public static boolean isSumProperty(Node root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.data;

        if (root.right != null)
            sum += root.right.data;

        return (sum == root.data) && isSumProperty(root.left) && isSumProperty(root.right);

    }
}
