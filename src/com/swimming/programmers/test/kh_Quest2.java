package com.swimming.programmers.test;

public class kh_Quest2 {
    /**
     * Lev.1 완주하지 못한 선수
     * 100%
     */
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
        final kh_Quest2 solution = new kh_Quest2();
        int result = solution.solution(4);

        System.out.println(result);
    }
}


