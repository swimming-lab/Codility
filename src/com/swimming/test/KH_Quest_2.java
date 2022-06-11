package com.swimming.test;

/**
 * kakaohair
 */
public class KH_Quest_2 {
    public int solution(long N) {
        int answer = 0;

        long inputNum = N;
        while (inputNum > 0) {
            long count = 0;
            long num = 1;
            while (inputNum >= num * 2) {
                num *= 2;
                count++;
            }
            inputNum -= num;
            answer += sumOfDistinctPowerOf3(count);
        }

        return answer;
    }

    long sumOfDistinctPowerOf3(long count) {
        long sum = 1L;
        for (int i = 0; i < count; i++){
            sum *= 3;
        }
        return sum;
    }

    public static void main(String[] args) {
        final KH_Quest_2 solution = new KH_Quest_2();
        int result = solution.solution(4);

        System.out.println(result);
    }
}


