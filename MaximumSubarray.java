package com.clrs.algorithms;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] prices = TestHelper.generateRandomArray(1, 50, 10);

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        TestHelper.printArray(prices);
//        int result = maximumSubarray.calculate1(prices);
        int result = maximumSubarray.calculate2(prices);
        System.out.println("\nmaximum profit = [" + result + "]");
    }

    public int calculate1(int[] prices) {
        if (prices.length < 2) return 0;
        int sum = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = Math.max(0, prices[i] - prices[i - 1] + sum);
            maxProfit = Math.max(maxProfit, sum);
        }
        return maxProfit;
    }

    public int calculate2(int[] prices){
        if (prices.length < 2) return 0;
        int min = prices[0], maxProfit = 0;
        for(int i =1;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        return maxProfit;
    }
}
