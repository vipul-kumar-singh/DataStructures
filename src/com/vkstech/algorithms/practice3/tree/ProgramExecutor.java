package com.vkstech.algorithms.practice3.tree;

public class ProgramExecutor {

    public static void main(String[] args) {
        MBinaryTree bt1 = new MBinaryTree();
        bt1.insertLevelOrder(1, 2, 3, 4, 5);
        bt1.printInorder();
        System.out.println(bt1.getHeight(bt1.root));

        MBinaryTree bt2 = new MBinaryTree();
        bt2.insertLevelOrder(8, 1, 5, -1, 7, 10, 6, -1, 10, 6);
        bt2.printInorder();
        System.out.println(bt2.getHeight(bt2.root));

        MBinaryTree bt3 = new MBinaryTree();
        bt3.insertLevelOrder(1, 4, -1, 4, 2);
        bt3.printPreorder();
        System.out.println(bt3.getHeight(bt3.root));

        MBinaryTree bt4 = new MBinaryTree();
        bt4.insertLevelOrder(6, 3, 2, -1, 1, 2, -1);
        bt4.printPreorder();
        System.out.println(bt4.getHeight(bt4.root));

        MBinaryTree bt5 = new MBinaryTree();
        bt5.insertLevelOrder(19, 10, 8, 11, 13);
        bt5.printPostorder();
        System.out.println(bt5.getHeight(bt5.root));

        MBinaryTree bt6 = new MBinaryTree();
        bt6.insertLevelOrder(11, 15, -1, 7);
        bt6.printPostorder();
        System.out.println(bt6.getHeight(bt6.root));

        MBinaryTree bt7 = new MBinaryTree();
        bt7.insertLevelOrder(1, 2, 3);
        bt7.printLevelOrder();
        System.out.println(bt7.getHeight(bt7.root));

        MBinaryTree bt8 = new MBinaryTree();
        bt8.insertLevelOrder(10, 20, 30, 40, 50);
        bt8.printLevelOrder();
        System.out.println(bt8.getHeight(bt8.root));
    }
}
