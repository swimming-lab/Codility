package com.swimming.codility;

public class Lesson5_CountDiv {
    public int solution(int A, int B, int K) {
        // correctness 100%, performance 0%, O(B-A)
        int result = 0;
        for(int i=A; i<=B; i++) {
            if (i % K == 0) {
                result++;
            }
        }

        return result;
    }

    public int solution2(int A, int B, int K) {
        // correctness 100%, performance 0%, O(1)
        int result = 0;

        if (A % K == 0) {
            result = (B / K) - (A / K) + 1;
        } else {
            result = (B / K) - (A / K);
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson5_CountDiv solution = new Lesson5_CountDiv();

//        int result = solution.solution2(6, 11, 2);
        int result = solution.solution2(11, 345, 17);
        System.out.println(result);
    }
}


