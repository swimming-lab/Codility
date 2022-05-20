package com.swimming.codility;

public class Lesson3_FrogJmp {
    public int solution(int X, int Y, int D) {
        // correctness 100%, performance 100%, O(1)
        int count = Y / D - X / D;
        if (count * D + X >= Y) {
            return count;
        } else {
            return count+1;
        }
    }

    public static void main(String[] args) {
        final Lesson3_FrogJmp solution = new Lesson3_FrogJmp();

        int result = solution.solution(50, 199, 4);
        System.out.println(result);
    }
}


