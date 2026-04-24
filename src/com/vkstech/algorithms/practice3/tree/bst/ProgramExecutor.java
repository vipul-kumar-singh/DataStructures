package com.vkstech.algorithms.practice3.tree.bst;

public class ProgramExecutor {

    public static void main(String[] args) {
        MBinarySearchTree bt1 = new MBinarySearchTree();
        bt1.insert(2, 1, 3);
        bt1.printLevelOrder();
        bt1.insert(bt1.root, 4);
        bt1.printLevelOrder();
    }
}
