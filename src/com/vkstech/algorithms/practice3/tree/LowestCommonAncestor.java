package com.vkstech.algorithms.practice3.tree;

import java.util.LinkedList;
import java.util.List;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.N;
import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

// https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
public class LowestCommonAncestor {

    public static void main(String[] args) {
        MBinaryTree tree1 = new MBinaryTree();
        tree1.insertLevelOrder(1, 2, 3, 4, 5, 6, 7);
        System.out.println(lca(tree1.root, 4, 5).data);

        MBinaryTree tree2 = new MBinaryTree();
        tree2.insertLevelOrder(1, 2, 3, 4, 5, 6, 7, N, N, N, N, 8);
        System.out.println(lca(tree2.root, 7, 8).data);
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null)
            return new Node(-1);

        List<Integer> n1Path = new LinkedList<>();
        List<Integer> n2Path = new LinkedList<>();

        getPath(root, n1, n1Path);
        getPath(root, n2, n2Path);

        int minLength = Math.min(n1Path.size(), n2Path.size());

        int previous = -1;
        for (int i = 0; i < minLength; i++) {
            if (!n1Path.get(i).equals(n2Path.get(i)))
                return new Node(previous);
            previous = n1Path.get(i);
        }

        return new Node(previous);
    }

    private static boolean getPath(Node node, int n, List<Integer> path) {
        if (node == null)
            return false;

        path.add(node.data);

        if (node.data == n ||
                getPath(node.left, n, path) ||
                getPath(node.right, n, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
