package com.vkstech.algorithms.sorting;

public class InsertionSort {

    public static int[] insertionSort(int arr[]){
        int j;
        int key;
        for (int i= 1; i < arr.length ; i++){

            j = i-1;
            key = arr[i];

            while (j > -1 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {8, 5, 6, 0, 3, 2,1};
        insertionSort(arr);
        CommonUtils.printArray(arr);
    }
}
