package com.vkstech.algorithms.practice3.slidingWindow;

// https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/
public class ScoreCalculator {

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 4, 3, 5};
        System.out.println(calculateScoreLessThanK(arr1, 10));

        int[] arr2 = {1, 1, 1};
        System.out.println(calculateScoreLessThanK(arr2, 5));
    }

    private static long calculateScoreLessThanK(int[] arr   , long k) {
        int start = 0;
        int end = 0;

        long sum = 0;
        long score;

        long n = arr.length;
        long count = 0;

        while (end < n) {

            sum += arr[end];
            score = (end - start + 1)*sum;

            while (score >= k && start <=end) {
                sum -= arr[start];
                start++;
                score = (end - start + 1)*sum;
            }

            count += (end - start + 1);
            end++;
        }

        return count;
    }
}
