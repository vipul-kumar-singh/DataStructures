package com.vkstech.algorithms.practice2.tree;

import com.vkstech.algorithms.practice2.tree.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        LevelOrderInsertion.insert(bt, 35);
        LevelOrderInsertion.insert(bt, 19);
        LevelOrderInsertion.insert(bt, 16);
        LevelOrderInsertion.insert(bt, 15);
        LevelOrderInsertion.insert(bt, 4);
        LevelOrderInsertion.insert(bt, 10);
        LevelOrderInsertion.insert(bt, 6);

        System.out.println(getLca(bt.root, 15, 10));
        System.out.println(getLca(bt.root, 15, 4));

        System.out.println(getDistanceBtwNodes(bt.root, 15, 10));
        System.out.println(getDistanceBtwNodes(bt.root, 15, 4));
    }

    private static int getDistanceBtwNodes(Node node, int n1, int n2) {
        if (node == null)
            return -1;

        List<Integer> n1Path = new ArrayList<>();
        List<Integer> n2Path = new ArrayList<>();

        getPath(node, n1, n1Path);
        getPath(node, n2, n2Path);

        int k = Math.min(n1Path.size(), n2Path.size());
        int lcaHeight = -1;

        for (int i = 0; i < k; i++) {
            if (!n1Path.get(i).equals(n2Path.get(i)))
                break;

            lcaHeight++;
        }

        return (n1Path.size() - 1) + (n2Path.size() - 1) - (2 * lcaHeight);
    }

    private static int getLca(Node node, int n1, int n2) {
        if (node == null)
            return -1;

        List<Integer> n1Path = new ArrayList<>();
        List<Integer> n2Path = new ArrayList<>();

        getPath(node, n1, n1Path);
        getPath(node, n2, n2Path);

        int k = Math.min(n1Path.size(), n2Path.size());
        int lca = -1;

        for (int i = 0; i < k; i++) {
            if (!n1Path.get(i).equals(n2Path.get(i)))
                return lca;

            lca = n1Path.get(i);
        }

        return lca;
    }

    private static boolean getPath(Node node, int n, List<Integer> path) {
        if (node == null)
            return false;

        path.add(node.data);

        if (node.data == n || getPath(node.left, n, path) || getPath(node.right, n, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }
}
