package com.swimming.test;

/**
 * n*n 크기의 행령의 각 칸에 1부터 n^2 까지의 숫자가 지그재그 방향으로 채워져 있습니다.
 *
 * n=5 일 때
 * 1 2 6 7 15
 * 3 5 8 14 16
 * 4 9 13 17 22
 * 10 12 18 21 23
 * 11 19 20 24 25
 *
 * 이때 r행, c열의 칸에 어떤 숫자가 적혀있는지 구하려고 합니다. 예를 들어 위 그림에서 r=3, c=2인 경우에는 9가 들어 있습니다.
 * n, r, c가 주어질 때 배열의 값을 찾으시오.
 */
public class ELD_Quest_2 {
    public long solution(int n, int r, int c) {
        long answer = 0;

        /**
         * 세로 공식
         * 1 + 2*1 (1)
         * 3 + 1   (2)
         * 4 + 2*3 (3)
         * 10 + 1  (4)
         * 11 + 2*5(5)
         * 21 + 1  (6)
         * 22 + 2*7(7)
         * 36
         *
         * 가로 공식
         * 1 + 1   (1)
         * 2 + 2*2 (2)
         * 6 + 1   (3)
         * 7 + 2*4 (4)
         * 15 + 1  (5)
         * 16 + 2*6(6)
         * 28 + 1  (7)
         * 29
         */

        return answer;
    }

    public static void main(String[] args) {
        final ELD_Quest_2 solution = new ELD_Quest_2();
        long result = solution.solution(5, 3, 2);

        System.out.println(result);
    }
}




