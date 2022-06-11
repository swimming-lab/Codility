package com.swimming.test;

public class SK11_Quest_2 {
    public int solution(int[] A) {
        // correctness 100%, performance 100%

        int result = 0;
        for(int i=0; i<A.length; i++) {
            // 반복분 1번에 앞/뒤 동시에 진행해서 O(N/2)으로 나눈다.
            // i/j는 앞에서 체크, i/jEnd는 디에서 체크
            int iEnd = (A.length-1) - i;
            if (i > iEnd) {
                break;
            } else {
                for(int j=i; j<A.length; j++) {
                    int jEnd = (A.length-1) - j;
                    int start_result = A[i] + A[j] + (i>j ? (i-j) : (j-i));
                    int end_result = A[iEnd] + A[jEnd] + (iEnd>jEnd ? (iEnd-jEnd) : (jEnd-iEnd));

                    result = Math.max(result, Math.max(start_result, end_result));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final SK11_Quest_2 solution = new SK11_Quest_2();
//        int result = solution.solution(new int[]{-8, 4, 0, 5, -3, 6});
        int result = solution.solution(new int[]{1, 3, -3});
        System.out.println(result);
    }
}


