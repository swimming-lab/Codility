package com.swimming.codility;

public class Lesson1_BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        char[] binaries = Integer.toBinaryString(N).toCharArray();
        System.out.println("start~!");
        System.out.println("N =" + N);

        int result = 0;
        int startIndex = 0;
        for(int i=0; i<binaries.length; i++) {            
            if ((binaries[i]-'0') == 1 && startIndex == 0) {
                startIndex = i + 1;
                System.out.println("1. startIndex =" + startIndex);
            } else if ((binaries[i]-'0') == 1 && startIndex > 0) {
                if (result < (i - startIndex)) {
                    result = i - startIndex;
                    System.out.println("result =" + result);
                }
                startIndex = i + 1;
                System.out.println("2. startIndex =" + startIndex);
            }
        }

        System.out.println("result =" + result);
        System.out.println("end~!");
        return result;
    }

    public static void main(String[] args) {
        final Lesson1_BinaryGap solution = new Lesson1_BinaryGap();
        solution.solution(1042);
    }
}


