package com.swimming.codility;

import java.util.HashMap;
import java.util.Map;

public class Lesson6_Distinct {
    public int solution(int[] A) {
        // correctness 100%, performance 100%, O(N)
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            map.put(A[i], 1);
        }
        result = map.size();

        return result;
    }

    public static void main(String[] args) {
        final Lesson6_Distinct solution = new Lesson6_Distinct();

//        int result = solution.solution(new int[]{2, 1, 1, 2, 3, 1});
        int result = solution.solution(new int[]{0});
        System.out.println(result);
    }
}


