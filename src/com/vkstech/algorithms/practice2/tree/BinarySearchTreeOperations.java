package com.vkstech.algorithms.practice2.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

        int[] inOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTree bst1 = getBstFromArray(inOrder);
        BinaryTreeTraversal.inOrder(bst1.root);
        System.out.println();

        System.out.println("Nodes in range: " + countNodesInRange(bst.root, 8, 18));

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(50);
        bst2.insert(30);
        bst2.insert(70);
        bst2.insert(20);
        bst2.insert(40);
        bst2.insert(60);
        bst2.insert(80);
        addAllGreaterValues(bst2.root);
        BinaryTreeTraversal.inOrder(bst2.root);
        System.out.println();

        int[] preSuc = findPreSuc(bst.root, 4);
        System.out.println("Predecessor: " + preSuc[0]);
        System.out.println("Successor: " + preSuc[1]);

        System.out.println("Closest neighbour: " + closestNeighbour(bst.root, 7));

        BinarySearchTree bst3 = bstToBalancedBst(bst);
        BinaryTreeTraversal.inOrder(bst3.root);
        System.out.println();

        findPairSum(bst, 34);
        findPairSum(bst, 10);
        findPairSum(bst, 11);

        System.out.println(isValidBst(bst.root));
        System.out.println(isValidBst(bst1.root));
        System.out.println(isValidBst(bst2.root));
        System.out.println(isValidBst(bst3.root));

        int[] preOrderArr = {15, 4, 10, 6, 19, 16, 35};
        BinarySearchTree bst4 = getBstFromPreorder(preOrderArr);
        BinaryTreeTraversal.preOrder(bst4.root);
        System.out.println();
        BinaryTreeTraversal.inOrder(bst4.root);
        System.out.println();

        printLeafNodesFromPreOrder(preOrderArr);
    }

    public static int getMin(Node node) {
        if (node == null)
            return -1;

        if (node.left == null)
            return node.data;

        return getMin(node.left);
    }

    public static BinarySearchTree getBstFromArray(int[] arr) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = getBstFromArray(arr, 0, arr.length);
        return bst;
    }

    private static Node getBstFromArray(int[] arr, int start, int end) {
        if (start >= end)
            return null;

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = getBstFromArray(arr, start, mid);
        node.right = getBstFromArray(arr, mid + 1, end);
        return node;
    }

    public static int countNodesInRange(Node node, int min, int max) {
        if (node == null)
            return 0;

        int sum = 0;
        if (node.data >= min && node.data <= max)
            sum++;

        return sum + countNodesInRange(node.left, min, max) + countNodesInRange(node.right, min, max);
    }

    public static void addAllGreaterValues(Node node) {
        addAllGreaterValues(node, new AtomicInteger());
    }

    private static void addAllGreaterValues(Node node, AtomicInteger sum) {
        if (node == null)
            return;

        addAllGreaterValues(node.right, sum);

        sum.set(sum.get() + node.data);
        node.data = sum.get();

        addAllGreaterValues(node.left, sum);
    }

    public static int[] findPreSuc(Node node, int key) {
        int[] arr = {-1, -1};
        arr = findPreSuc(node, key, arr);
        return arr;
    }

    private static int[] findPreSuc(Node node, int key, int[] arr) {
        if (node == null)
            return arr;

        if (key < node.data) {
            arr[1] = node.data;
            return findPreSuc(node.left, key, arr);
        }

        if (key > node.data) {
            arr[0] = node.data;
            return findPreSuc(node.right, key, arr);
        }

        if (node.left != null) {
            Node tmp = node.left;
            while (tmp.right != null)
                tmp = tmp.right;
            arr[0] = tmp.data;
        }

        if (node.right != null) {
            Node tmp = node.right;
            while (tmp.left != null)
                tmp = tmp.left;
            arr[1] = tmp.data;
        }

        return arr;
    }

    public static int closestNeighbour(Node node, int key) {
        if (node == null)
            return -1;

        if (node.data == key)
            return node.data;

        if (key < node.data && node.left != null) {
            int n = closestNeighbour(node.left, key);
            return Math.min(node.data, n);
        }

        if (key > node.data && node.right != null) {
            int n = closestNeighbour(node.right, key);
            return Math.max(node.data, n);
        }

        return key < node.data ? -1 : node.data;
    }

    public static BinarySearchTree bstToBalancedBst(BinarySearchTree bst) {
        Queue<Integer> inOrderQueue = getInorderFromBst(bst.root, new LinkedList<>());
        int[] inOrderArray = new int[inOrderQueue.size()];
        int i = 0;
        while (!inOrderQueue.isEmpty())
            inOrderArray[i++] = inOrderQueue.remove();

        return getBstFromArray(inOrderArray);
    }

    private static Queue<Integer> getInorderFromBst(Node node, Queue<Integer> inOrderQueue) {
        if (node == null)
            return null;

        getInorderFromBst(node.left, inOrderQueue);
        inOrderQueue.add(node.data);
        getInorderFromBst(node.right, inOrderQueue);

        return inOrderQueue;
    }

    public static void findPairSum(BinarySearchTree bst, int sum) {
        if (bst == null || bst.root == null)
            return;

        Set<Integer> set = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(bst.root);

        int num1 = -1;
        int num2 = -1;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (set.contains(node.data)) {
                num1 = node.data;
                num2 = sum - node.data;
                break;
            }

            if (node.data > sum) {
                queue.add(node.left);
                continue;
            }

            int diff = sum - node.data;
            set.add(diff);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        if (num1 == -1 && num2 == -1)
            System.out.println("There's no pair that sums up to " + sum + ".");
        else
            System.out.println("Nodes with value " + num1 + " and " + num2 + " sum up to " + sum + ".");
    }

    public static boolean isValidBst(Node node) {
        if (node == null)
            return true;

        if ((node.left != null && node.left.data > node.data)
                || (node.right != null && node.right.data < node.data)) {
            return false;
        }

        return isValidBst(node.left) && isValidBst(node.right);
    }

    public static BinarySearchTree getBstFromPreorder(int[] preOrder) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = getBstFromPreOrder(preOrder, 0, preOrder.length);
        return bst;
    }

    private static Node getBstFromPreOrder(int[] arr, int start, int end) {
        if (start == end)
            return null;

        Node node = new Node(arr[start]);
        int i = start + 1;

        if (i < arr.length && node.data > arr[start + 1]) {
            while (i < arr.length && node.data > arr[i]) {
                i++;
            }
        }

        node.left = getBstFromPreOrder(arr, start + 1, i);
        node.right = getBstFromPreOrder(arr, i, end);
        return node;
    }

    public static void printLeafNodesFromPreOrder(int[] preorder) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, j = 1; j < preorder.length; i++, j++) {
            boolean found = false;

            if (preorder[i] > preorder[j]) {
                stack.push(preorder[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (preorder[j] > stack.peek()) {
                        stack.pop();
                        found = true;
                    } else {
                        break;
                    }
                }
            }

            if (found)
                list.add(preorder[i]);
        }

        list.forEach(obj -> System.out.print(obj + " "));
        System.out.println();
    }

}
