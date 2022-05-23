package com.swimming.codility;

import java.util.Arrays;

public class Lesson4_PermCheck {
    public int solution(int[] A) {
        // correctness 100%, performance 100%, O(N) or O(N * log(N))
        Arrays.sort(A);

        int result = 1;
        if (A.length == 1) {
            if (A[0] > 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (A[0] != 1) {
                return 0;
            }
        }

        for(int i=0; i<A.length-1; i++) {
            if (A[i]+1 != A[i+1]) {
                result = 0;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson4_PermCheck solution = new Lesson4_PermCheck();

        int result = solution.solution(new int[]{3,2});
        System.out.println(result);
    }
}


