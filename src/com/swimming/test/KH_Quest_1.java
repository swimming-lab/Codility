package com.swimming.test;

import java.util.Arrays;
import java.util.Collections;

/**
 * kakaohair
 */
public class KH_Quest_1 {
    public int solution(int N) {
        int answer = -1;

        String temp = Integer.toString(N);
        String[] numbersAsc = new String[temp.length()];
        String[] numbersDesc = new String[temp.length()];
        for (int i=0; i<temp.length(); i++) {
            String str = String.valueOf(temp.charAt(i));
            numbersAsc[i] = str;
            numbersDesc[i] = str;
        }

        Arrays.sort(numbersAsc);
        Arrays.sort(numbersDesc, Collections.reverseOrder());

        System.out.println(Arrays.toString(numbersAsc));
        System.out.println(Arrays.toString(numbersDesc));

        String strAsc = "";
        String strDesc = "";
        for (int i=0; i<temp.length(); i++) {
            strAsc += numbersAsc[i];
            strDesc += numbersDesc[i];
        }

        answer = Integer.parseInt(strAsc) + Integer.parseInt(strDesc);

        return answer;
    }

    public static void main(String[] args) {
        final KH_Quest_1 solution = new KH_Quest_1();
        int result = solution.solution(2613);

        System.out.println(result);
    }
}


