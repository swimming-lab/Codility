package com.swimming.codility;

public class Lesson2_CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        int shift = 0;
        if (A.length == 1 || A.length == 0) {
            shift = 0;
        } else if (A.length > K) {
            shift = K;
        } else {
            shift = K % A.length;
        }

        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++) {
            int position = i + shift;
            if (position >= A.length) {
                position = position - A.length;
            }

            result[position] = A[i];
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson2_CyclicRotation solution = new Lesson2_CyclicRotation();

        solution.solution(new int[]{}, 0);
    }
}


