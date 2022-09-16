package com.swimming.test;

/**
 * 알파벳이 적힌 카드 24장이 한 줄에 8장씩, 세 줄로 놓여 있습니다.
 * 같은 알파벳이 적힌 카드가 여러 장 있을 수 있으나, 같은 알파벳이 적힌 카드는 반드시 같은 줄에 놓여 있습니다.
 *
 * 어떤 단어들이 주어질 떄, 각 단어를 주어진 카드로 만들 수 있는지 판별하려고 합니다.
 * 단, 주어진 카드로 만들 때는 반드시 한 줄에 한 카드는 사용해야 합니다.
 */
public class FW_Quest_3 {

    int answer;
    int n;
    int k;

    private void jump(int position, int move, int count) {
        if (position > n) {
            return;
        }

        if (count == k) {
            if (position == n) {
                this.answer++;
            }
            return;
        }

        for (int i=1; i<move; i++) {
            jump(position + (move - i), move - i, count + 1);
        }
    }

    public int solution(int n, int k) {
        this.n = n;
        this.k = k;

        int start = n / k + 1;

        for (int i=start; i<n; i++) {
            jump(i, i, 1);
        }

        return this.answer % 1000000007;
    }

    public static void main(String[] args) {
        final FW_Quest_3 solution = new FW_Quest_3();
        int result = solution.solution(9, 3);

        System.out.println(result);
    }
}
