package com.vkstech.algorithms.practice3.tree;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.*;

public class HeightBalanced {

    public static void main(String[] args) {
        MBinaryTree tree1 = new MBinaryTree();
        tree1.insertLevelOrder(10, 20, 30, 40, 60);
        System.out.println(isBalanced(tree1.root));

        MBinaryTree tree2 = new MBinaryTree();
        tree2.insertLevelOrder(1, 2, 3, 4, N, N, N, 5);
        System.out.println(isBalanced(tree2.root));

        MBinaryTree tree3 = new MBinaryTree();
        tree3.insertLevelOrder(6, 7, N, 3, N, N, N, 1, N, N, N, N, N, N, N, 4);
        System.out.println(isBalanced(tree3.root));
    }

    public static boolean isBalanced(Node root) {
        if (root == null) return true;

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }
}
