package com.vkstech.algorithms.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Count pairs with given sum
 * Input  :  arr[] = {1, 5, 7, -1, 5},
 *           sum = 6
 * Output :  3
 * Pairs with sum 6 are (1, 5), (7, -1) & (1, 5)
 */
public class CountPairSum {

    private static int countPairWithSum(int[] arr, int sum) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int val : arr){
            countMap.merge(val, 1, Integer::sum);
        }
        int twiceCount = 0;
        for(int val : arr){
            if (countMap.containsKey(sum - val))
                twiceCount += countMap.get(sum - val);

            if (sum - val == val)
                twiceCount--;
        }
        return twiceCount/2;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 5, 7, -1};
        int sum = 6;
        System.out.println(countPairWithSum(input1, sum));
        int[] input2 = {1, 5, 7, -1, 5};
        sum = 6;
        System.out.println(countPairWithSum(input2, sum));
        int[] input3 = {1, 1, 1, 1};
        sum = 2;
        System.out.println(countPairWithSum(input3, sum));
        int[] input4 = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        sum = 11;
        System.out.println(countPairWithSum(input4, sum));
    }
}
