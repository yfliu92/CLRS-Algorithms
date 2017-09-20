package com.clrs.algorithms;

public class TestHelper {
    private TestHelper() {
    }

    public static int[] generateRandomArray(int low, int high, int N) {
        assert low <= high : "assertion fail";
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) ((high - low + 1) * Math.random() + low);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

}
