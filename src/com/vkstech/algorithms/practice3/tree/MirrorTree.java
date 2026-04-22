package com.vkstech.algorithms.practice3.tree;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.N;
import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

// https://www.geeksforgeeks.org/problems/mirror-tree/1
public class MirrorTree {

    public static void main(String[] args) {
        MBinaryTree tree1 = new MBinaryTree();
        tree1.insertLevelOrder(1, 2, 3, N, N, 4);
        tree1.printLevelOrder();
        mirror(tree1.root);
        tree1.printLevelOrder();

        System.out.println("-------------------------------------");

        MBinaryTree tree2 = new MBinaryTree();
        tree2.insertLevelOrder(1, 2, 3, 4, 5);
        tree2.printLevelOrder();
        mirror(tree2.root);
        tree2.printLevelOrder();

    }

    public static void mirror(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            mirror(root.left);
        }

        if (root.right != null) {
            mirror(root.right);
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
