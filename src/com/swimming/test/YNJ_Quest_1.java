package com.swimming.test;

import java.util.Arrays;

public class YNJ_Quest_1 {
    public int solution(int[] A) {
        // correctness 80%, performance 83%
        Arrays.sort(A);

        int result = Integer.MIN_VALUE;

        if (A.length == 2) {
            return (A[1] - A[0]) / 2;
        }

        for (int i=0; i<A.length-1; i++) {
            if (A[i+1] - A[i] > 1) {
                result = Math.max(result, A[i+1] - A[i]);
            }
        }

        return result / 2;
    }

    public static void main(String[] args) {
        final YNJ_Quest_1 solution = new YNJ_Quest_1();
        int result = solution.solution(new int[]{10, 0, 8, 2, -1, 12, 11, 3});
//        int result = solution.solution(new int[]{5, 5});
        System.out.println(result);
    }
}


