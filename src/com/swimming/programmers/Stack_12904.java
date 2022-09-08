package com.swimming.programmers;

import java.util.Stack;

/**
 * 가장 긴 팰린드롬
 * lev.3
 * https://school.programmers.co.kr/learn/courses/30/lessons/12904
 *
 * 문제 설명
 * 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 * 문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
 *
 * 예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.
 *
 * 제한사항
 * 문자열 s의 길이 : 2,500 이하의 자연수
 * 문자열 s는 알파벳 소문자로만 구성
 * 입출력 예
 * s	        answer
 * "abcdcba"	7
 * "abacde"	    3
 * 입출력 예 설명
 * 입출력 예 #1
 * 4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.
 *
 * 입출력 예 #2
 * 2번째자리 'b'를 기준으로 "aba"가 팰린드롬이 되므로 3을 return합니다.
 */
public class Stack_12904 {
    // TODO solution 둘다 전체 테스트 케이스에서 1~2개 실패(이유는 전체가 팰린드롬 예외처리 안함), 효율성 1 실패
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<=i; j++) {
                stack.push(s.charAt(j));
            }

            if (i + 2 > s.length()-1) {
                stack.clear();
                break;
            }

            int count = 0;
            for (int j=0; j<=i; j++) {
                if (j+i+2 > s.length()-1) {
                    stack.clear();
                    break;
                }
                if (stack.pop() == s.charAt(j+i+2)) {
                    count++;
                } else {
                    stack.clear();
                    break;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer * 2 + 1;
    }

    char[] chars;

    public int solution2(String s) {
        int answer = 0;

        chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            answer = Math.max(answer, palindrome(i, 1));
        }

        return answer;
    }

    private int palindrome(int index, int add) {
        if (index == 0 || index == chars.length-1) {
            return 0;
        }

        if (index - add < 0 || index + add > chars.length-1) {
            return (add-1) * 2 + 1;
        } else if (chars[index - add] == chars[index + add]) {
            return palindrome(index, add+1);
        } else {
            return (add-1) * 2 + 1;
        }
    }

    public static void main(String[] args) {
        final Stack_12904 solution = new Stack_12904();
        int result1 = solution.solution("abcdcba");
//        int result2 = solution.solution2("abcdcba");
//        int result2 = solution.solution2("abacda");
        System.out.println(result1);
    }
}


