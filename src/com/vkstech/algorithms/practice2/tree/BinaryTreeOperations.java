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

    public static int getLeavesCount(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return getLeavesCount(node.left) + getLeavesCount(node.right);
    }

    public static boolean childrenSumProperty(Node node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        int sum = 0;
        if (node.left != null) {
            sum += node.left.data;
            boolean leftValue = childrenSumProperty(node.left);
            if (!leftValue)
                return false;
        }

        if (node.right != null) {
            sum += node.right.data;
            boolean rightValue = childrenSumProperty(node.right);
            if (!rightValue)
                return false;
        }

        return node.data == sum;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        LevelOrderInsertion.insert(bt, 35);
        LevelOrderInsertion.insert(bt, 20);
        LevelOrderInsertion.insert(bt, 15);
        LevelOrderInsertion.insert(bt, 15);
        LevelOrderInsertion.insert(bt, 5);
        LevelOrderInsertion.insert(bt, 10);
        LevelOrderInsertion.insert(bt, 5);

        System.out.println("Height = " + getHeight(bt.root, 1));
        System.out.println("Height = " + getHeight(bt.root));

        System.out.println("Leaves Count = " + getLeavesCount(bt.root));

        System.out.println("Check CSP: " + childrenSumProperty(bt.root));
    }

}
