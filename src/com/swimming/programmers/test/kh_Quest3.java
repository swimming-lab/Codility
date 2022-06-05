package com.swimming.programmers.test;

import java.util.*;

public class kh_Quest3 {
    private static final int[] DR = {1, 0, -1, 0};  // 하 우 상 좌 순으로 움직임
    private static final int[] DC = {0, 1, 0, -1};  // 하 우 상 좌 순으로 움직임
    private static final int BLOCK_POSTION = 1;
    private static final int START_POSTION = 2;
    private static final int END_POSTION = 3;

    static class Pos {
        int r, c, cost;
        public Pos(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public int solution(int[][] board, int c) {
        int answer = Integer.MAX_VALUE;

        final int R = board.length;
        final int C = board[0].length;

        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        // 시작 위치 찾기
        loop:
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (board[i][j] == START_POSTION) {
                    // 시작 위치 발견 시 큐에 넣고 루프 종료, 시작 위치 방문한 것으로 체크
                    q.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                    break loop;
                }
            }
        }

        // BFS 알고리즘 시작
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            // 인접한(상하좌우) 칸으로 탐색 진행
            for (int i=0; i<DR.length; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];
                int cost = cur.cost + 1;

                // 다음 탐색할 위치가 맵을 벗어나거나 이미 방문한 곳인 경우 탐색 제외
                if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC]) {
                    continue;
                }

                // 장애물을 만났을 때 + c
                if (board[nextR][nextC] == BLOCK_POSTION) {
                    cost = cost + c;
                }

                // 목적지 도착
                if (board[nextR][nextC] == END_POSTION) {
                    answer = Math.min(answer, cost);
                    System.out.println(cost);
                } else {
                    // 큐에 다음 탐색할 곳을 추가, 방문했던 위치 체크
                    q.add(new Pos(nextR, nextC, cost));
                    visited[nextR][nextC] = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final kh_Quest3 solution = new kh_Quest3();
        int result1 = solution.solution(new int[][]
                {
                    {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
                },1);
        System.out.println("----------");
        int result2 = solution.solution(new int[][]
                {
                    {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                    {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
                },2);

//        System.out.println(result1);
        System.out.println(result2);
    }
}


