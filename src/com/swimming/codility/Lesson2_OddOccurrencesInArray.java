package com.swimming.codility;

import java.util.Arrays;

public class Lesson2_OddOccurrencesInArray {
    public int solution(int[] A) {
        // correctness 100%, performance 100%, O(N) or O(N*log(N))
        Arrays.sort(A);

        int result = 0;
        if (A.length == 1) {
            return A[0];
        }

        for(int i=0; i<A.length; i++) {
            if (A.length == i+1) {
                result = A[i];
                break;
            } else if (A[i] == A[i+1]) {
                i++;
            } else {
                result = A[i];
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson2_OddOccurrencesInArray solution = new Lesson2_OddOccurrencesInArray();

        solution.solution(new int[]{2, 2, 3, 3, 4});
    }
}


