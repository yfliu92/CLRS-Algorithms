package com.clrs.algorithms;

import java.util.Arrays;

public class ActivitySelection {
    public static void main(String[] args) {
        int[][] activities = new int[][]{{0, 10}, {1, 8}, {3, 6}, {7, 11}, {9, 14}, {12, 15}};
        ActivitySelection ex = new ActivitySelection();
        int res = ex.solution(activities);
        System.out.println(res);
    }

    public int solution(int[][] A) {
        int len = A.length;
        if (len <= 1) return len;
        Arrays.sort(A, (a, b) -> (a[1] - b[1]));
        int res = 0;
        int lastEndTime = 0;
        for (int i = 0; i < len; i++) {
            int start = A[i][0];
            int end = A[i][1];
            if (lastEndTime <= start) {
                res++;
                lastEndTime = end;
            }
        }
        return res;
    }
}
