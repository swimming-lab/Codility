package com.swimming.test;

/**
 * 알파벳이 적힌 카드 24장이 한 줄에 8장씩, 세 줄로 놓여 있습니다.
 * 같은 알파벳이 적힌 카드가 여러 장 있을 수 있으나, 같은 알파벳이 적힌 카드는 반드시 같은 줄에 놓여 있습니다.
 *
 * 어떤 단어들이 주어질 떄, 각 단어를 주어진 카드로 만들 수 있는지 판별하려고 합니다.
 * 단, 주어진 카드로 만들 때는 반드시 한 줄에 한 카드는 사용해야 합니다.
 */
public class FW_Quest_2_2 {

        public static void main(String[] args) {

            int N = 5;
            int[][] arr = new int[N][N];
            int text = 1;

            // 윗 삼각형
            for (int i=0; i<N; i++) {	//커서 옮기는 역할
                int cnt = 0;

                //홀수
                if (i%2 == 0) {
                    for (int c = 0; c < i+1; c++) {	//내부 반복횟수
                        arr[i-cnt][0+cnt] = text++;
                        cnt++;
                    }

                    //짝수
                } else {
                    for (int c = 0; c < i+1; c++) {
                        arr[0+cnt][i-cnt] = text++;
                        cnt++;
                    }
                }
            }

            // 아래 삼각형
            for (int i = 1; i <= N-1; i++) {	//커서 옮기는 역할(줄바꾸기)
                int cnt = 0;

                //홀수
                if ((i + N-1)%2 == 0) {
                    for (int c = i; c < N; c++) {	//내부 반복횟수
                        arr[N-1-cnt][i+cnt] = text++;
                        cnt++;
                    }

                    //짝수
                } else {
                    for (int c = i; c < N; c++) {
                        arr[i+cnt][N-1-cnt] = text++;
                        cnt++;
                    }
                }
            }

            //출력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
}
