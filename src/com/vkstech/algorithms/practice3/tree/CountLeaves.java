package com.vkstech.algorithms.practice3.tree;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

// https://www.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
public class CountLeaves {

    public static void main(String[] args) {
        MBinaryTree tree1 = new MBinaryTree();
        tree1.insertLevelOrder(4, 8, 10, 7, -1, 5, 1, 3);
        System.out.println(countLeaves(tree1.root));

        MBinaryTree tree2 = new MBinaryTree();
        tree2.insertLevelOrder(50, 30, 70, 20, 40, 60, 80, -1, -1, -1, -1, -1, 65);
        System.out.println(countLeaves(tree2.root));

        MBinaryTree tree3 = new MBinaryTree();
        tree3.insertLevelOrder(30, 25, 35, 20, 28, -1, 40, -1, -1, 27);
        System.out.println(countLeaves(tree3.root));
    }

    public static int countLeaves(Node node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }
}
