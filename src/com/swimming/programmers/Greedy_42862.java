package com.swimming.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 탐욕법(Greedy)
 * Lev.1 체육복
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 *
 * 문제 설명
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어,
 * 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 *
 * 예를 들어,
 * 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 * 벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 *
 * 입출력 예
 * n	lost	reserve	return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	4
 * 3	[3]	[1]	2
 *
 * 입출력 예 설명
 * 예제 #1
 * 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
 *
 * 예제 #2
 * 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
 */
public class Greedy_42862 {
    public int solution1(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 2개 가져온 학생 set, 잃어버린 학생 set 만들기
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        for (int i : reserve) {
            reserveSet.add(i);
        }
        for (int i : lost) {
            // 2개 가져왔으나 잃어버렸으면 그냥 1개 가져온걸로
            if (reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }

        // 2개 가져온 학생의 앞(i-1), 뒤(i+1)에 잃어버린 학생이 있으면 빌려쥼
        for (int i : reserveSet) {
            if (lostSet.contains(i - 1)) {
                lostSet.remove(i - 1);
            } else if (lostSet.contains(i + 1)) {
                lostSet.remove(i + 1);
            }
        }

        // 전체 학생 - 잃어버린 학생 수
        answer = n - lostSet.size();

        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 학생 배열을 생성(앞뒤 계산으로 배열 크기 +2)
        // 2개 가져온 학생은 1, 잃어버린 학생은 -1
        int[] students = new int[n + 2];
        for (int r : reserve) {
            students[r]++;
        }
        for (int l : lost) {
            students[l]--;
        }

        // 2개 가져온 학생의 앞(i-1), 뒤(i+1)에 잃어버린 학생이 있으면 빌려쥼
        for (int i=1; i<=n; i++) {
            if (students[i] == 1) {
                if (students[i - 1] == -1) {
                    students[i]--;
                    students[i - 1]++;
                } else if (students[i + 1] == -1) {
                    students[i]--;
                    students[i + 1]++;
                }
            }
        }

        // 전체 학생 - 잃어버렸고 못 빌려받았은 학생 수
        for (int i=1; i<=n; i++) {
            if (students[i] > -1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final Greedy_42862 solution = new Greedy_42862();
        int result1 = solution.solution1(	5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println(result1);

        int result2 = solution.solution2(	5, new int[]{2, 4}, new int[]{3});
        System.out.println(result2);

    }
}


