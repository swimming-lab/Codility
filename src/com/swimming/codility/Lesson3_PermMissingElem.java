package com.swimming.codility;

import java.util.Arrays;

public class Lesson3_PermMissingElem {
    public int solution(int[] A) {
        // correctness 100%, performance 100%, O(N) or O(N * log(N))
        Arrays.sort(A);

        int result = 1;
        if (A.length == 1) {
            if (A[0] > 1) {
                return 1;
            } else {
                return A[0]+1;
            }
        }

        for(int i=0; i<A.length; i++) {
            if (i+1 == A.length) {
                if (A[0] != 1) {
                    result = 1;
                } else {
                    result = A[i]+1;
                }
                break;
            } else if (A[i]+1 != A[i+1]) {
                result = A[i]+1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson3_PermMissingElem solution = new Lesson3_PermMissingElem();

//        int result = solution.solution(new int[]{2, 3, 1, 5});
        int result = solution.solution(new int[]{1, 2});
        System.out.println(result);
    }
}


