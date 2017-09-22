package com.clrs.algorithms;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] prices = TestHelper.generateRandomArray(1, 50, 10);

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        TestHelper.printArray(prices);

//        int result = maximumSubarray.calculate1(prices);
//        int result = maximumSubarray.calculate2(prices);

        int[] arrayDifferences = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            arrayDifferences[i] = prices[i] - prices[i - 1];
        }

        System.out.println("\n");
        TestHelper.printArray(arrayDifferences);

        int[] result = maximumSubarray.findMaximumSubarray(arrayDifferences, 0, arrayDifferences.length - 1);
        System.out.println("\nresult = [" + result[0] + "," + result[1] + "," + result[2] + "]");
    }

    // Divide & Conquer
    // the format of return : low index, high index, the sum of maximum subarray
    // if used in the Stock example, the return value "low" should minus 1, then the index
    // (low -1) can be the day to buy stock
    public int[] findMaximumSubarray(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            int[] left = findMaximumSubarray(arr, low, mid);
            int[] right = findMaximumSubarray(arr, mid + 1, high);
            int[] cross = findCrossMaximumSubarray(arr, low, mid, high);
            if (left[2] >= right[2] && left[2] >= cross[2]) {
                return left;
            } else if (right[2] >= left[2] && right[2] >= cross[2]) {
                return right;
            } else {
                return cross;
            }
        }
        return new int[]{low, high, arr[low]};
    }

    public int[] findCrossMaximumSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftIndex = low;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rightIndex = high;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }
        return new int[]{leftIndex, rightIndex, rightSum + leftSum};
    }

    // Method 2
    public int calculate1(int[] prices) {
        if (prices.length < 2) return 0;
        int sum = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = Math.max(0, prices[i] - prices[i - 1] + sum);
            maxProfit = Math.max(maxProfit, sum);
        }
        return maxProfit;
    }

    // Method 3
    public int calculate2(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
}
