package com.vkstech.algorithms.practice.tree;

/**
 * Left View of Binary Tree
 * Given a Binary Tree, print left view of it.
 * Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
 */
public class ViewLeft extends BinaryTree {

    private static int maxLevel = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(4);
        binaryTree.root.left = new Node(5);
        binaryTree.root.right = new Node(2);
        binaryTree.root.right.right = new Node(1);
        binaryTree.root.right.left = new Node(3);
        binaryTree.root.right.left.left = new Node(6);
        binaryTree.root.right.left.right = new Node(7);

        leftView(binaryTree);
    }

    private static void leftView(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.root == null)
            return;

        printLeftView(binaryTree.root, 1);
    }

    private static void printLeftView(Node node, int level) {
        if (node == null)
            return;

        if (maxLevel < level) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        printLeftView(node.left, level + 1);
        printLeftView(node.right, level + 1);
    }
}
