package com.vkstech.algorithms.practice3.arrays;

public class MinDistance {

    public static void main(String[] args) {
        int[] arr = new int []{10, 20, 30, 40, 50, 10};
        System.out.println(getMinDistance(arr,10,50));
        System.out.println(getMinDistance(arr,20,50));
        System.out.println(getMinDistance(arr,20,40));
        System.out.println(getMinDistance(arr,20,70));
        System.out.println(getMinDistance(arr,90,50));
    }

    private static int getMinDistance(int[] arr, int a, int b) {
        int ai = -1;
        int bi = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a){
                ai = i;

                if (bi != -1){
                    min = Math.min(Math.abs(ai - bi), min);
                }
            } else if (arr[i] == b) {
                bi = i;

                if (ai != -1) {
                    min = Math.min(Math.abs(ai - bi), min);
                }
            }
        }

        if (ai == -1 || bi == -1)
            return -1;

        return min;
    }
}