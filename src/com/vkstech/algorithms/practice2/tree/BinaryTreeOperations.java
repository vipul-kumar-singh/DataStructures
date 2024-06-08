package com.vkstech.algorithms.practice2.tree;

public class BinaryTreeOperations extends BinaryTree {

    public static int getHeight(Node node, int n) {
        if (node == null)
            return n;

        int height = n;
        int lHeight;
        int rHeight;

        if (node.left != null) {
            lHeight = getHeight(node.left, n + 1);
            height = Math.max(lHeight, n);
        }

        if (node.right != null) {
            rHeight = getHeight(node.right, n + 1);
            height = Math.max(rHeight, height);
        }

        return height;
    }

    public static int getHeight(Node node) {
        if (node == null)
            return 0;

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        LevelOrderInsertion.insert(bt, 1);
        LevelOrderInsertion.insert(bt, 2);
        LevelOrderInsertion.insert(bt, 3);
        LevelOrderInsertion.insert(bt, 4);
        LevelOrderInsertion.insert(bt, 5);
        LevelOrderInsertion.insert(bt, 6);
        LevelOrderInsertion.insert(bt, 7);
        LevelOrderInsertion.insert(bt, 8);

        System.out.println("Height = " + getHeight(bt.root, 1));
        System.out.println("Height = " + getHeight(bt.root));
    }

}
