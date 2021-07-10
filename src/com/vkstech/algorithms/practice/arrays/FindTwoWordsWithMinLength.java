package com.vkstech.algorithms.practice.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTwoWordsWithMinLength {

    public static void main(String[] args) {
        String input = "We are the Venom";
        getMinTwoWords(input);
    }

    private static void getMinTwoWords(String str) {
        String[] words = str.split(" ");

        Comparator<String> comparator = Comparator
                .comparing(String::length)
                .reversed()
                .thenComparing(String::compareToIgnoreCase);

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(2, comparator);
        for(String word : words){
            if (priorityQueue.size() == 2){
                String peekWord = priorityQueue.peek();
                if ((peekWord.length() > word.length()) ||
                        (peekWord.length() == word.length() &&
                                peekWord.compareToIgnoreCase(word) > 0)) {
                    priorityQueue.poll();
                    priorityQueue.add(word);
                }
            } else {
                priorityQueue.add(word);
            }
        }
        priorityQueue.forEach(System.out:: println);
    }
}
