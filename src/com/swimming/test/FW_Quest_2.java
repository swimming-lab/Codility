package com.swimming.test;

import java.util.Arrays;

/**
 * 알파벳이 적힌 카드 24장이 한 줄에 8장씩, 세 줄로 놓여 있습니다.
 * 같은 알파벳이 적힌 카드가 여러 장 있을 수 있으나, 같은 알파벳이 적힌 카드는 반드시 같은 줄에 놓여 있습니다.
 *
 * 어떤 단어들이 주어질 떄, 각 단어를 주어진 카드로 만들 수 있는지 판별하려고 합니다.
 * 단, 주어진 카드로 만들 때는 반드시 한 줄에 한 카드는 사용해야 합니다.
 */
public class FW_Quest_2 {
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
        final FW_Quest_2 solution = new FW_Quest_2();
        long result = solution.solution(10000000, 10000000, 10000000);

        System.out.println(result);
    }
}
