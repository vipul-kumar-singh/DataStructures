package com.vkstech.algorithms.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, convert it into its mirror.
 * * * 1          1
 * * /  \    => /  \
 * 3     2     2    3
 */
public class MirrorTree extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        LevelOrderInsertion.insert(bTree, 1);
        LevelOrderInsertion.insert(bTree, 2);
        LevelOrderInsertion.insert(bTree, 3);
        LevelOrderInsertion.insert(bTree, 4);
        LevelOrderInsertion.insert(bTree, 5);
        Traversal.printInOrder(bTree);

        convertToMirror(bTree);
        Traversal.printInOrder(bTree);
    }

    private static void convertToMirror(BinaryTree tree) {
        if (tree == null || tree.root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }
    }
}
