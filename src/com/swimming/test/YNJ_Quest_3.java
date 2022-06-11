package com.swimming.test;

import java.util.HashMap;
import java.util.Map;

public class YNJ_Quest_3 {
    public int solution(int[] X, int[] Y) {
        // correctness 28%, performance 14%

        int result = 1;
        int count = 0;
        double num;
        Map<Double, Integer> hash = new HashMap<Double, Integer>();

        for (int i=0; i<X.length; i++) {
            num = new Double((double)X[i] / (double)Y[i]);
            if (hash.get(num) != null) {
                count = hash.get(num);
                if (count + 1 > result) {
                    result = count + 1;
                }
                hash.put(num, result);
            } else {
                hash.put(num, 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final YNJ_Quest_3 solution = new YNJ_Quest_3();
        int result = solution.solution(new int[]{1,2,3,4,0}, new int[]{2,3,6,8,4});
        System.out.println(result);
    }
}


