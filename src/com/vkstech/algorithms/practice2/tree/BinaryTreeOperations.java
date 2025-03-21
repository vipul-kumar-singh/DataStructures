package com.vkstech.algorithms.practice2.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

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


    private static Node convertToMirror(Node node) {
        if (node == null)
            return null;

        Node temp = node;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.remove();

            Node swap = temp.left;
            temp.left = temp.right;
            temp.right = swap;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }

        return node;
    }

    public static int lowestCommonAncestor(Node node, int n1, int n2) {
        if (node == null)
            return -1;

        List<Integer> n1Path = new LinkedList<>();
        List<Integer> n2Path = new LinkedList<>();

        getPath(node, n1, n1Path);
        getPath(node, n2, n2Path);

        int minLength = Math.min(n1Path.size(), n2Path.size());

        int previous = -1;
        for (int i = 0; i < minLength; i++) {
            if (!n1Path.get(i).equals(n2Path.get(i)))
                return previous;
            previous = n1Path.get(i);
        }

        return previous;
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

    public static int diameter(Node node) {
        if (node == null)
            return -1;

        int sum = 1;

        if (node.left != null)
            sum += getHeight(node.left);

        if (node.right != null)
            sum += getHeight(node.right);

        return sum;
    }

    public static void printLeftView(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                Node temp = queue.remove();

                if (i == 1)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public static void printRightView(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                Node temp = queue.remove();

                if (i == n)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }


    public static int findMaxSumPath(Node parent, AtomicInteger maxSum) {
        if (parent == null)
            return 0;

        int left = findMaxSumPath(parent.left, maxSum);
        int right = findMaxSumPath(parent.right, maxSum);

        if (parent.left == null)
            return right + parent.data;

        if (parent.right == null)
            return left + parent.data;

        int cur_sum = left + right + parent.data;
        maxSum.set(Math.max(cur_sum, maxSum.get()));

        return Math.max(left, right) + parent.data;
    }

    public static int findMaxSumPath(BinaryTree binaryTree) {
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE);
        findMaxSumPath(binaryTree.root, maxSum);
        return maxSum.get();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        LevelOrderInsertion.insert(bt, 35);
        LevelOrderInsertion.insert(bt, 19);
        LevelOrderInsertion.insert(bt, 16);
        LevelOrderInsertion.insert(bt, 15);
        LevelOrderInsertion.insert(bt, 4);
        LevelOrderInsertion.insert(bt, 10);
        LevelOrderInsertion.insert(bt, 6);

        System.out.println("Height = " + getHeight(bt.root, 1));
        System.out.println("Height = " + getHeight(bt.root));

        System.out.println("Leaves Count = " + getLeavesCount(bt.root));

        System.out.println("Check CSP: " + childrenSumProperty(bt.root));

        System.out.println("\nInOrder before mirroring: ");
        BinaryTreeTraversal.inOrder(bt.root);
//        convertToMirror(bt.root);
//        System.out.println("\nInorder after mirroring");
//        BinaryTreeTraversal.inOrder(bt.root);

        System.out.println("\nLCA: " + lowestCommonAncestor(bt.root, 10, 4));

        System.out.println("Diameter: " + diameter(bt.root));

        System.out.println("Left View: ");
        printLeftView(bt.root);
        System.out.println("\nRight View: ");
        printRightView(bt.root);


        System.out.println("\nMax Sum : " + findMaxSumPath(bt));
    }

}
