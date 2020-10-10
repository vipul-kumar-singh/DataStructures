package com.vkstech.algorithms.sorting;

public class MergeSort {

    private static void merge(int arr[], int p, int q, int r) {
        int[] left = new int[q - p + 1];
        int right[] = new int[r - q];

        int i = 0;
        int j = 0;

        for (j = p; j <= q; j++) {
            left[i] = arr[j];
            i = i + 1;
        }

        i = 0;
        for (j = q + 1; j <= r; j++) {
            right[i] = arr[j];
            i = i + 1;
        }

        i = 0;
        j = 0;
        for (int k = p; k <= r; k++) {
            if (i < left.length && (j >=right.length || left[i] <= right[j])){
                arr[k] = left[i];
                i = i+ 1;
            } else if (j < right.length){
                arr[k] = right[j];
                j = j+1;
            }
        }

    }


    private static void mergeSort(int arr[], int p, int r){
        if (p < r){
            int q = (p+r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }


    public static void main(String[] args) {
        int arr[] = {8, 5, 6, 0, 3, 2,1};
        mergeSort(arr, 0, arr.length - 1);
        CommonUtils.printArray(arr);
    }
}
