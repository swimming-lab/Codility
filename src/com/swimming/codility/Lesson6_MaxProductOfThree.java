package com.swimming.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lesson6_MaxProductOfThree {
    public int solution(int[] A) {
        // correctness 100%, performance 0%, O(N**3)
        int result = Integer.MIN_VALUE;
//        for (int P=0; P<A.length; P++) {
//            for (int Q=P+1; Q<A.length; Q++) {
//                for (int R=Q+1; R<A.length; R++) {
//                    result = Math.max(result, A[P] * A[Q] * A[R]);
//                }
//            }
//        }

        // correctness 100%, performance 100%, O(N * log(N))
        Arrays.sort(A);
        result = A[A.length-1] * A[A.length-2] * A[A.length-3];

        if (A[0] < 0 && A[1] < 0 && A[A.length-1] > 0) {
            if (result < A[A.length-1] * A[1] * A[0]) {
                result = A[A.length-1] * A[1] * A[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson6_MaxProductOfThree solution = new Lesson6_MaxProductOfThree();

//        int result = solution.solution(new int[]{-3, 1, 2, -2, 5, 6});
//        int result = solution.solution(new int[]{-10, -2, -4});
        int result = solution.solution(new int[]{-5, 5, -5, 4});
        System.out.println(result);
    }
}


