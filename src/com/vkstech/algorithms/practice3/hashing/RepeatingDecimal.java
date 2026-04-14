package com.vkstech.algorithms.practice3.hashing;

import java.util.HashMap;
import java.util.Map;

public class RepeatingDecimal {

    public static void main(String[] args) {
        int a1 = 1, b1 = 2;
        System.out.println(calculateFraction(a1, b1));

        int a2 = 50, b2 = 22;
        System.out.println(calculateFraction(a2, b2));
    }

    public static String calculateFraction(int a, int b) {
        if (a == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((a < 0) ^ (b < 0)) result.append("-");

        long num = Math.abs((long) a);
        long den = Math.abs((long) b);

        // Integer part
        result.append(num / den);
        num %= den;

        if (num == 0) return result.toString();

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (num != 0) {
            if (map.containsKey(num)) {
                int start = map.get(num);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            map.put(num, result.length());
            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }
}
