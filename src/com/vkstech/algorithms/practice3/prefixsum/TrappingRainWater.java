package com.vkstech.algorithms.practice3.prefixsum;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 5, 2, 6, 2, 3};
        System.out.println(getMaxStorage(height));
        System.out.println(getMaxStorageOptimized(height));
    }

    private static int getMaxStorage(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = 0;

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        int maxStorage = 0;

        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            int storage = min - height[i];
            if (storage > 0) {
                maxStorage += storage;
            }
        }

        return maxStorage;
    }

    private static int getMaxStorageOptimized(int[] height) {
        int n = height.length;
        int maxHeight = 0;
        int maxHeightIndex = -1;

        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        int leftMax = 0;
        int rightMax = 0;
        int maxStorage = 0;

        for (int i = 0; i < maxHeightIndex; i++) {
            if (leftMax > height[i])
                maxStorage += leftMax - height[i];
            else
                leftMax = height[i];
        }

        for (int i = n - 1; i > maxHeightIndex; i--) {
            if (rightMax > height[i])
                maxStorage += rightMax - height[i];
            else
                rightMax = height[i];
        }
        return maxStorage;
    }

}
