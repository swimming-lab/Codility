package com.swimming.codility;

import java.util.Arrays;

public class Lesson4_MaxCounters {
    public int[] solution(int N, int[] A) {
        // correctness 100%, performance 100%, O(N + M)

        int[] result = new int[N];
        int currentMax = 0;
        int modifyMax = 0;

        for(int i=0; i<A.length; i++) {
            if (A[i] > N) {
                // max counter
//                for(int j=0; j< result.length; j++) {
//                    result[j] = max;
//                }
                modifyMax = currentMax;
            } else {
                // counter
                int target = A[i] - 1;
                if (result[target] < modifyMax) {
                    result[target] = modifyMax + 1;
                } else {
                    result[target] += 1;
                }

                currentMax = Math.max(currentMax, result[target]);
            }
        }

        for(int j=0; j< result.length; j++) {
            if (result[j] < modifyMax) {
                result[j] = modifyMax;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson4_MaxCounters solution = new Lesson4_MaxCounters();

        int[] result = solution.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        System.out.println(Arrays.toString(result));
    }
}


