package com.clrs.algorithms;

public class Dynamic_0_1_Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(dynamicKnapsack(wt, val, n, W));
    }

    public static int dynamicKnapsack(int[] weight, int[] value, int n, int W) {

        if (n == 0 || W == 0) return 0;
        if (weight[n] < W) {
            c[i][k] = Math.max(c[i - 1][k], (c[i - 1][k - weight[i]] + value[i]));
        } else {
            c[i][k] = c[i - 1][k];
        }
        return c[n][W];
    }
}
