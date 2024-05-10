package com.vkstech.algorithms.practice2.linkedlist;

public class Sort012 extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(1, 2, 2, 1, 2, 0, 2, 2);
        System.out.println(linkedList);

        sort(linkedList);
        System.out.println(linkedList);
    }

    private static void sort(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null)
            return;

        Node temp = linkedList.head;
        int[] arr = new int[3];

        while (temp != null) {
            arr[temp.data]++;
            temp = temp.next;
        }

        temp = linkedList.head;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                temp.data = i;
                temp = temp.next;
            }
        }
    }
}
