package com.swimming.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OSB_Quest_3 {
    public int solution(int[] stats) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<stats.length; i++) {
            boolean joined = false;
            for (int key : map.keySet()) {
                if (map.get(key) < stats[i]) {
                    map.put(key, stats[i]);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                map.put(i, stats[i]);
            }
        }

        return map.size();
    }

    public static void main(String[] args) {
        final OSB_Quest_3 solution = new OSB_Quest_3();
        int result = solution.solution(new int[]{5,3,4,6,2,1});

        System.out.println(result);
//        System.out.println(Arrays.toString(result));
    }
}
