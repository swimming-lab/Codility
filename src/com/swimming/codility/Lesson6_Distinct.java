package com.swimming.codility;

import java.util.Arrays;

public class Lesson6_Distinct {
    public int solution(int[] A) {
        // correctness 100%, performance 0%, O(B-A)
        Arrays.sort(A);
        int result = 0;
        int count = 0;

        if (A.length > 0) {
            result = A[0];
            count = 1;
        }

        for (int i=1; i<A.length; i++) {
            if (A[i] != result) {
                if (count == 1) {
                    break;
                }
                result = A[i];
                count = 1;
            } else {
                count++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson6_Distinct solution = new Lesson6_Distinct();

//        int result = solution.solution(new int[]{2, 1, 1, 2, 3, 1});
        int result = solution.solution(new int[]{0});
        System.out.println(result);
    }
}


