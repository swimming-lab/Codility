package com.swimming.codility;

import java.util.Arrays;

public class Lesson4_MissingInteger {
    public int solution(int[] A) {
        // correctness 80%, performance 50%
        Arrays.sort(A);

        int result = 0;
        int firstPostive = 0;
        boolean isPositive = false;

        // single
        if (A.length == 1) {
            if (A[0] > 0) {
                isPositive = true;
                if (A[0] > 1) {
                    return A[0] - 1;
                } else {
                    return A[0] + 1;
                }
            }
        }

        for(int i=0; i<A.length-1; i++) {
            // check int
            if (!isPositive) {
                if (A[i] > 0) {
                    firstPostive = A[i];
                    isPositive = true;
                }
            }

            if (A[i] == A[i+1] || A[i]+1 == A[i+1]) {
                continue;
            } else {
                result = A[i] + 1;
                break;
            }
        }

        if (!isPositive) {
            return 1;
        }

        if (result == 0) {
            result = A[A.length-1] + 1;
        }

        if (firstPostive > 1 && result > 0) {
            return 1;
        }

        return result;
    }

    public int solution2(int[] A) {
        // correctness 100%, performance 100%
        Arrays.sort(A);

        int result = 1;

        for(int i =0; i<A.length; i++) {
            // 양의정수가 아니거나, result 보다 작을 경우
            if (A[i] < 1 || A[i] < result) {
                continue;
            }

            if (A[i] > result) {
                return result;
            } else {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson4_MissingInteger solution = new Lesson4_MissingInteger();

//        int result = solution.solution(new int[]{1, 3, 6, 4, 1, 2});
//        int result = solution.solution(new int[]{1});
        int result = solution.solution2(new int[]{4, 5, 6, 2});
//        int result = solution.solution(new int[]{90, 91, 92, 93});


        System.out.println(result);
    }
}


