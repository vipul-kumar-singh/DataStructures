package com.vkstech.algorithms.practice2.tree;

public class BinarySearchTreeOperations extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(15);
        bst.insert(19);
        bst.insert(35);
        bst.insert(16);
        bst.insert(4);
        bst.insert(10);
        bst.insert(6);

        System.out.println(getMin(bst.root));

    }

    private static int getMin(Node node) {
        if (node == null)
            return -1;

        if (node.left == null)
            return node.data;

        return getMin(node.left);
    }

}
