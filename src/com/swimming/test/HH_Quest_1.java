package com.swimming.test;

import java.util.*;

public class HH_Quest_1 {
    public int[] solution(int n, int m) {
        if (n < 2 || n > 100) {
            return new int[0];
        }
        if (m < 1 || m > 100) {
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<Integer> answerArr = new ArrayList<Integer>();
        int rmLength = 0;
        int th = 1;
        while(true) {
            for (int i = 1; i <= n; i++) {
                if (map.get(i) == null && th == m && n - rmLength > 1) {
                    map.put(i,  i);
                    th = 1;
                    rmLength++;
                    answerArr.add(i);
                    continue;
                } else if (map.get(i) != null) {
                    continue;
                }
                th++;
            }

            if (n - rmLength == 1) {
                break;
            }
        }

        return answerArr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        final HH_Quest_1 solution = new HH_Quest_1();
        int[] result = solution.solution(5, 2);

        System.out.println(Arrays.toString(result));
    }
}

