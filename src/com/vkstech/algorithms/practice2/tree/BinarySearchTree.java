package com.vkstech.algorithms.practice2.tree;

public class BinarySearchTree extends BinaryTree {

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);

        return node;

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);

        BinaryTreeTraversal.inOrder(bst.root);

    }
}
