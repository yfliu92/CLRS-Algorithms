package com.clrs.algorithms;

public class Dynamic_0_1_Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(dynamicKnapsack(wt, val, n, W));
    }

    public static int dynamicKnapsack(int[] wt, int[] val, int n, int W) {

        if (n == 0 || W == 0) return 0;
        if (wt[n - 1] > W) {
            return dynamicKnapsack(wt, val, n - 1, W);
        } else {
            return Math.max(dynamicKnapsack(wt, val, n - 1, W), (dynamicKnapsack(wt, val, n - 1, W - wt[n - 1]) + val[n - 1]));
        }
    }
}
