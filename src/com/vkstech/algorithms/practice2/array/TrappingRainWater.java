package com.vkstech.algorithms.practice2.array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 5, 2, 6, 2, 3};

        System.out.println(getMaxWater(height));
        System.out.println(getMaxWaterOptimized(height));
    }

    private static int getMaxWater(int[] height) {
        int n = height.length;

        int[] leftHeight = new int[n];
        leftHeight[0] = 0;

        for (int i = 1; i < n; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i - 1]);
        }

        int[] rightHeight = new int[n];
        rightHeight[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i + 1]);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftHeight[i], rightHeight[i]);

            if (minHeight > height[i])
                sum += (minHeight - height[i]);
        }

        return sum;
    }

    private static int getMaxWaterOptimized(int[] height) {
        int n = height.length;

        int maxHeight = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        int leftMax = 0;
        int water = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (leftMax > height[i]) {
                water += (leftMax - height[i]);
            }
            leftMax = Math.max(leftMax, height[i]);
        }

        int rightMax = 0;
        for (int i = n - 1; i > maxIndex; i--) {
            if (rightMax > height[i]) {
                water += (rightMax - height[i]);
            }
            rightMax = Math.max(rightMax, height[i]);
        }

        return water;
    }
}
