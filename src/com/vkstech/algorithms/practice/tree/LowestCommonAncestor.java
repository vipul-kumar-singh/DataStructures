package com.vkstech.algorithms.practice.tree;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Lowest Common Ancestor in a Binary Tree
 * Given a Binary Tree with all unique values and two nodes value n1 and n2.
 * The task is to find the lowest common ancestor of the given two nodes.
 * We may assume that either both n1 and n2 are present in the tree or none of them is present.
 */
public class LowestCommonAncestor extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 7).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.left.left, binaryTree.root.left.right)); // 2
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.right.left, binaryTree.root.right.right)); // 3
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.left.left, binaryTree.root.right.right)); // 1
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.left.right, binaryTree.root.right.left)); // 1
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.left, binaryTree.root.right)); // 1
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root, binaryTree.root.right)); // 1
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.left, binaryTree.root)); // 1
        System.out.println(getLowestCommonAncestor(binaryTree, new Node(4), binaryTree.root.right.right)); // -1
        System.out.println(getLowestCommonAncestor(binaryTree, binaryTree.root.left.left, new Node(6))); // -1

    }

    private static int getLowestCommonAncestor(BinaryTree tree, Node nodeA, Node nodeB) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        getPathOfNode(tree.root, nodeA, stack1);
        getPathOfNode(tree.root, nodeB, stack2);

        Node common = null;
        while (!stack1.empty() && !stack2.empty()){
            if (stack1.peek() != stack2.peek())
                break;

            common = stack1.pop();
            stack2.pop();
        }

        if (common == null){
            System.out.println("No common node");
            return -1;
        }

        return common.data;
    }

    private static boolean getPathOfNode(Node parent, Node node, Stack<Node> stack) {
        if (parent == null)
            return false;

        if (parent == node || getPathOfNode(parent.left, node, stack) || getPathOfNode(parent.right, node, stack)) {
            stack.add(parent);
            return true;
        }

        return false;
    }

}
