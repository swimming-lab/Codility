package com.swimming.test;

public class YNJ_Quest_2 {
    public int solution(int[] blocks) {
        // correctness 100%, performance 33%

        int result = 0;
        for(int i=0; i<blocks.length; i++) {
            int left = i;
            int right = i;

            // left
            if (i > 0) {
                for (int l=i-1; l>=0; l--) {
                    if (blocks[left] <= blocks[l]) {
                        left = l;
                    } else {
                        break;
                    }
                }
            } else {
                left = i;
            }

            // right
            if (i < blocks.length-1) {
                for (int r=i+1; r<blocks.length; r++) {
                    if (blocks[right] <= blocks[r]) {
                        right = r;
                    } else {
                        break;
                    }
                }
            } else {
                right = i;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        final YNJ_Quest_2 solution = new YNJ_Quest_2();
        int result = solution.solution(new int[]{1, 5, 5, 2, 6});
//        int result = solution.solution(new int[]{2,6,8,5});
        System.out.println(result);
    }
}


