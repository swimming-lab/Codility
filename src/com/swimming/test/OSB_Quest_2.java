package com.swimming.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OSB_Quest_2 {

    public int[] solution2(int[] price) {
        int[] answer = new int[price.length];
        answer[price.length-1] = -1;

        for (int i=0; i<price.length-1; i++) {
            int days = 1;
            for (int j=i+1; j<price.length; j++) {
                if (price[i] < price[j]) {
                    answer[i] = days;
                    break;
                } else if(j+1 == price.length) {
                    answer[i] = -1;
                    break;
                }
                days++;
            }
        }

        return answer;
    }

    public int[] solution(int[] price) {
        int[] answer = new int[price.length];
        answer[price.length-1] = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<price.length-1; i++) {
            int next = i+1;
            List<Integer> remove = new ArrayList<>();
            map.put(i, -1);

            for (int key : map.keySet()) {
                if (price[key] < price[next]) {
                    answer[key] = next - key;
                    remove.add(key);
                }
            }

            remove.stream().forEach(key -> map.remove(key));
        }

        for (int key : map.keySet()) {
            answer[key] = map.get(key);
        }

        return answer;
    }

    public static void main(String[] args) {
        final OSB_Quest_2 solution = new OSB_Quest_2();
        int[] result = solution.solution(new int[]{4,1,4,7,6});

        System.out.println(result);
//        System.out.println(Arrays.toString(result));
    }
}
