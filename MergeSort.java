package com.clrs.algorithms;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = TestHelper.generateRandomArray(1, 100, 10);
        TestHelper.printArray(arr);

        System.out.println("\n**********************************");

        MergeSort ms = new MergeSort();
        ms.sort(arr, 0, arr.length - 1);
        TestHelper.printArray(arr);
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {

        int[] leftArray = new int[mid - low + 1], rightArray = new int[high - mid];
        for (int i = 0; i < mid - low + 1; i++) {
            leftArray[i] = arr[i + low];
        }
        for (int i = 0; i < high - mid; i++) {
            rightArray[i] = arr[i + mid + 1];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < (mid - low + 1) && j < (high - mid)) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i++];
            } else {
                arr[k] = rightArray[j++];
            }
            k++;
        }
        while (i < (mid - low + 1)) {
            arr[k++] = leftArray[i++];
        }
        while (j < (high - mid)) {
            arr[k++] = rightArray[j++];
        }
    }
}
