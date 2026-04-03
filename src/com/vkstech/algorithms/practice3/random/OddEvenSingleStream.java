package com.vkstech.algorithms.practice3.random;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OddEvenSingleStream {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(71);
        list.add(18);
        list.add(42);
        list.add(21);
        list.add(67);
        list.add(32);
        list.add(95);
        list.add(14);
        list.add(56);
        list.add(87);

        list.stream()
                .sorted(Comparator.comparing(n -> n % 2 == 0))
                .forEach(System.out::println);
    }
}
