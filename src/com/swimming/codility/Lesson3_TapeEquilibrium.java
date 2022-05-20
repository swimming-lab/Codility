package com.swimming.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson3_TapeEquilibrium {
    public int solution(int[] A) {
        // correctness 100%, performance 100%, O(N)
        int left = 0;
        int right = 0;
        for(int i=0; i<A.length; i++) {
            right += A[i];
        }

        List<Integer> resultList = new ArrayList<>();
        for(int i=0; i<A.length-1; i++) {
            left = left + A[i];
            right = right - A[i];

            resultList.add(Math.abs(left - right));
        }

        return Collections.min(resultList);
    }

    public static void main(String[] args) {
        final Lesson3_TapeEquilibrium solution = new Lesson3_TapeEquilibrium();

        int result = solution.solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(result);
    }
}


