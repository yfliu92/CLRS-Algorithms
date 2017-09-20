package com.clrs.algorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = TestHelper.generateRandomArray(1, 100, 10);
        int[] sortedArr = insertionSort(arr);
        TestHelper.printArray(sortedArr);
    }

    public static int[] insertionSort(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            throw new IllegalArgumentException("Error Input");
        }
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
