package com.swimming.codility;

import java.util.HashMap;
import java.util.Map;

public class Lesson4_FrogRiverOne {
    public int solution(int X, int[] A) {
        // correctness 100%, performance 100%, O(N)
        int result = -1;
        if (X == 1) {
            return 0;
        }
        Map<Integer, Integer> leaves = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            if (A[i] <= X) {
                leaves.put(A[i], 0);
            }
            if (leaves.size() == X) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson4_FrogRiverOne solution = new Lesson4_FrogRiverOne();

        int result = solution.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(result);
    }
}


