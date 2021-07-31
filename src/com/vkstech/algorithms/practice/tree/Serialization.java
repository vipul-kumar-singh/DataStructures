package com.vkstech.algorithms.practice.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Serialize and Deserialize a Binary Tree
 * Serialization is to store tree in a array so that it can be later restored.
 * The structure of tree must be maintained.
 * Deserialization is reading tree back from file.
 */
public class Serialization extends BinaryTree {

    private final Queue<Integer> store = new LinkedList<>();

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 6).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        int[] serializedTree = serialize(binaryTree);
        System.out.println("Serialized Tree : " + Arrays.toString(serializedTree));

        BinaryTree deSerializedTree = new BinaryTree();
        deSerializedTree.root = deserialize(serializedTree, new AtomicInteger(0));

        Traversal.printInOrder(binaryTree);
        Traversal.printInOrder(deSerializedTree);
    }

    private static int[] serialize(BinaryTree binaryTree) {
        List<Integer> list = new ArrayList<>();
        serializeNode(binaryTree.root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void serializeNode(Node node, List<Integer> list) {
        list.add(node.data);

        if (node.left != null)
            serializeNode(node.left, list);
        else
            list.add(-1);

        if (node.right != null)
            serializeNode(node.right, list);
        else
            list.add(-1);
    }

    private static Node deserialize(int[] arr, AtomicInteger index) {
        Node node = new Node(arr[index.getAndIncrement()]);

        if (arr[index.get()] != -1)
            node.left = deserialize(arr, index);
        else
            index.getAndIncrement();

        if (arr[index.get()] != -1)
            node.right = deserialize(arr, index);
        else
            index.getAndIncrement();

        return node;
    }
}
