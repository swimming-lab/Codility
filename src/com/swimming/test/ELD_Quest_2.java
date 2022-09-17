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

        long[][] array = new long[n][n];
        long count = 1;
        long total = n * n;
        int x = 0;
        int y = -1;
        int upOrDown = 1;

        while (count <= total) {
            if (x == n - 1) {
                array[++y][x] = count++;
                upOrDown = 0;

                if (y == (r-1) && x == (c-1)) {
                    answer = array[y][x];
                    break;
                }
            }

            if (y == n - 1) {
                array[y][++x] = count++;
                upOrDown = 1;

                if (y == (r-1) && x == (c-1)) {
                    answer = array[y][x];
                    break;
                }
            }

            if (y == 0) {
                array[y][++x] = count++;
                upOrDown = 0;

                if (y == (r-1) && x == (c-1)) {
                    answer = array[y][x];
                    break;
                }
            }

            if (x == 0) {
                array[++y][x] = count++;
                upOrDown = 1;

                if (y == (r-1) && x == (c-1)) {
                    answer = array[y][x];
                    break;
                }
            }

            if (upOrDown == 1 && x != n - 1 && y != 0) {
                array[--y][++x] = count++;

                if (y == (r-1) && x == (c-1)) {
                    answer = array[y][x];
                    break;
                }
            }

            if (upOrDown == 0 && y != n - 1 && x != 0) {
                array[++y][--x] = count++;

                if (y == (r-1) && x == (c-1)) {
                    answer = array[y][x];
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final ELD_Quest_2 solution = new ELD_Quest_2();
        long result = solution.solution(5, 3, 2);

        System.out.println(result);
    }
}




