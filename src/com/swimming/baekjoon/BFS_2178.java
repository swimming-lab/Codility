package com.swimming.baekjoon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2178
 * 미로 탐색(BFS)
 *
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 1 초	192 MB	124448	52449	33704	40.922%
 *
 * 문제
 * N×M크기의 배열로 표현되는 미로가 있다. *
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 *
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 */
public class BFS_2178 {
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    static class Pos {
        int dr, dc, cost;
        public Pos(int dr, int dc, int cost) {
            this.dr = dr;
            this.dc = dc;
            this.cost = cost;
        }
    }

    public int solution(int N, int M, int[][] map) {
        // BFS, 최소거리
        // 방향키 객체 생성(이동 거리도 포함)
        // 큐 생성
        // 방향 이동마다 (N,M) 배열인지 확인
        // 공통 이전 방문지 제외
        int result = 0;
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 1));

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int i=0; i<DR.length; i++) {
                int nextR = pos.dr + DR[i];
                int nextC = pos.dc + DC[i];
                int cost = pos.cost + 1;

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || visited[nextR][nextC] || map[nextR][nextC] == 0) {
                    continue;
                }

                if (nextR == N-1 && nextC == M-1) {
                    return cost;
                } else {
                    visited[pos.dr][pos.dc] = true;
                    queue.add(new Pos(nextR, nextC, cost));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final BFS_2178 solution = new BFS_2178();
        int result1 = solution.solution(4, 6, new int[][]{
                {1,0,1,1,1,1},
                {1,0,1,0,1,0},
                {1,0,1,0,1,1},
                {1,1,1,0,1,1}
        });
        System.out.println(result1);
        System.out.println("----------");
        int result2 = solution.solution(4, 6, new int[][]{
                {1,1,0,1,1,0},
                {1,1,0,1,1,0},
                {1,1,1,1,1,1},
                {1,1,1,1,0,1}
        });
        System.out.println(result2);
        System.out.println("----------");
        int result3 = solution.solution(2, 25, new int[][]{
                {1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
                {1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1}
        });
        System.out.println(result3);
        System.out.println("----------");
        int result4 = solution.solution(7, 7, new int[][]{
                {1,0,1,1,1,1,1},
                {1,1,1,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,}
        });
        System.out.println(result4);
        System.out.println("----------");
    }
}


