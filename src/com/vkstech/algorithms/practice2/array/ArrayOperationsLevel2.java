package com.vkstech.algorithms.practice2.array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayOperationsLevel2 {

    public static void cyclicRotateArray(int[] arr, int k) {
        int[] tempArr = new int[k];
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            tempArr[i] = arr[n - k + i];
        }

        int i = n - 1;
        while (i >= k) {
            arr[i] = arr[i - k];
            i--;
        }

        while (i >= 0) {
            arr[i] = tempArr[i];
            i--;
        }
    }

    private static int findMissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2;
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(arr).forEach(sum::addAndGet);
        return totalSum - sum.get();
    }

    private static int countPairsWithSum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;


        for (int num : arr) {
            if (map.containsKey(sum - num)) {
                count += map.get(sum - num);
            }

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return count;
    }

    public static void findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length - 1);

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        map.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static void findCommonELements(int[]... arrs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr : arrs) {
            for (int num : arr) {
                if (map.containsKey(num))
                    map.put(num, map.get(num) + 1);
                else
                    map.put(num, 1);
            }
        }

        map.entrySet().stream().filter(entry -> entry.getValue() == arrs.length)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static int findFirstNotRepeatingElement(int[] arr) {
        boolean found;
        for (int i = 0; i < arr.length; i++) {
            found = false;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return arr[i];
        }
        return -1;
    }

    public static int countSubArrayWithEqualZeroAndOne(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = -1;

            sum += arr[i];

            if (sum == 0)
                count++;

            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }

    public static void reArrangeAltPositiveNegative(int[] arr) {
        if (arr.length <= 1)
            return;

        int left = 0;
        int right = 1;

        while (right < arr.length) {
            if (arr[left] >= 0 && arr[right] < 0
                    || arr[left] < 0 && arr[right] >= 0) {
                rotateSubArray(arr, left, right);
                left++;
                right++;
                continue;
            }

            if (arr[right] >= 0 || left == right)
                right++;

            if ((arr[left] < 0 && left % 2 == 0) || (arr[left] >= 0 && left % 2 != 0))
                left++;
        }
    }


    private static void rotateSubArray(int[] arr, int left, int right) {
        int temp = arr[right];

        int i = right;
        while (i > left) {
            arr[i] = arr[i - 1];
            i--;
        }

        arr[i] = temp;
    }

    public static boolean subArraySumZero(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;

            if (sum == 0 || num == 0 || set.contains(sum))
                return true;

            set.add(sum);
        }
        return false;
    }

    public static int largestSumOfSubArray(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];

        for (int num : arr) {
            sum = Math.max(num, sum + num);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static int[] factorial(int num) {
        int[] res = new int[200];
        res[199] = 1;

        for (int i = 2; i <= num; i++) {
            multiply(res, i);
        }

        return res;
    }

    public static void multiply(int[] arr, int k) {
        int n = arr.length - 1;

        int carry = 0;
        for (int i = n; i >= 0; i--) {
            int res = (arr[i] * k) + carry;
            arr[i] = res % 10;
            carry = res / 10;
        }

    }

    private static void printArrayAsNumber(int[] arr) {
        boolean printZero = false;

        for (int num : arr) {
            if (num != 0)
                printZero = true;

            if (printZero)
                System.out.print(num);
        }
        System.out.println();
    }

    public static int maximumProductSubArray(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];

        max[0] = min[0] = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                max[i] = Math.max(arr[i], max[i - 1] * arr[i]);
                min[i] = Math.min(arr[i], min[i - 1] * arr[i]);
            } else {
                max[i] = Math.max(arr[i], min[i - 1] * arr[i]);
                min[i] = Math.min(arr[i], max[i - 1] * arr[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }

    public static int findLongestConsecutiveSubsequence(int[] arr) {
        Set<Integer> set = new HashSet<>();

        Arrays.stream(arr).forEach(set::add);

        int maxCount = 0;

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public static int getMinInSortedAndRotatedArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int maxSumAmongRotations(int[] arr) {
        int n = arr.length;

        int curSum = 0;
        for (int num : arr)
            curSum += num;

        int curVal = 0;
        for (int i = 0; i < n; i++)
            curVal += (i * arr[i]);

        int result = curVal;

        for (int i = 1; i < n; i++) {
            int nextVal = curVal - (curSum - arr[i - 1]) + (arr[i - 1] * (n - 1));
            curVal = nextVal;
            result = Math.max(result, nextVal);
        }

        return result;
    }

    public static int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        int requiredPlatform = 1;

        // for values from 0 to 2360
        int[] platform = new int[2361];
        for (int i = 0; i < n; i++) {
            ++platform[arr[i]];
            --platform[dep[i] + 1];
        }

        for (int i = 1; i < 2361; i++) {
            platform[i] = platform[i] + platform[i - 1];
            requiredPlatform = Math.max(requiredPlatform, platform[i]);
        }

        return requiredPlatform;
    }

    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];

        int tempmin, tempmax;

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0)
                continue;

            tempmin = Math.min(arr[0] + k, arr[i] - k);
            tempmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, tempmax - tempmin);
        }
        return ans;
    }

    public static int findMinJumps(int[] arr) {
        int jumps = 1;

        for (int i = 0; i < arr.length; ) {
            int steps = arr[i];
            i = findMaxStep(arr, i + 1, i + steps);

            if (i >= arr.length - 1)
                break;

            jumps++;
        }
        return jumps;
    }

    private static int findMaxStep(int[] arr, int i, int j) {
        int max = i;

        if (j >= arr.length - 1)
            return arr.length;

        for (; i <= j; i++) {
            if (arr[i] > max)
                max = i;
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        cyclicRotateArray(arr1, 2);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 4, 6, 3, 7, 8};
        int n = 8;
        System.out.println(findMissingNumber(arr2, n));

        int[] arr3 = {1, 1, 1, 1};
        int sum = 2;
        System.out.println(countPairsWithSum(arr3, sum));

        int[] arr4 = {1, 2, 3, 6, 3, 6, 1};
        findDuplicates(arr4);

        int[] arr5 = {1, 5, 10, 20, 40, 80};
        int[] arr6 = {6, 7, 10, 20, 80, 100};
        int[] arr7 = {3, 4, 6, 7, 15, 20, 30, 70, 80, 120};
        findCommonELements(arr5, arr6, arr7);

        int[] arr8 = {-1, 2, -1, 2, 3, 2, 0};
        System.out.println(findFirstNotRepeatingElement(arr8));

        int[] arr9 = {1, 0, 0, 1, 1, 0, 0, 1};
        System.out.println(countSubArrayWithEqualZeroAndOne(arr9));

        int[] arr10 = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        reArrangeAltPositiveNegative(arr10);
        System.out.println(Arrays.toString(arr10));

        int[] arr11 = {4, 2, -3, 1, 6};
        System.out.println(subArraySumZero(arr11));

        int[] arr12 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(largestSumOfSubArray(arr12));

        int[] factorial = factorial(100);
        printArrayAsNumber(factorial);

        int[] arr13 = {6, -3, -10, 0, 2};
        System.out.println(maximumProductSubArray(arr13));

        int[] arr14 = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        System.out.println(findLongestConsecutiveSubsequence(arr14));

        int[] arr15 = {5, 6, 1, 2, 3, 4};
        System.out.println(getMinInSortedAndRotatedArray(arr15));

        int[] arr16 = {8, 3, 1, 2};
        System.out.println(maxSumAmongRotations(arr16));

        int[] arr = {100, 300, 600};
        int[] dep = {900, 400, 500};
        System.out.println(minPlatform(arr, dep));

        int[] arr17 = {1, 5, 15, 10};
        int k = 3;
        System.out.println(getMinDiff(arr17, k));

        int[] arr18 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(findMinJumps(arr18));

    }

}
