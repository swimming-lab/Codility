package com.swimming.programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 완전탐색(브루트포스)
 * Lev.2 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 *
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */
public class Bruteforce_42839 {
    Set<Integer> set = new HashSet<>();

    private void recursive(String combine, String others) {
        if (!combine.equals("")) {
            set.add(Integer.valueOf(combine));
        }

        for (int i=0; i<others.length(); i++) {
            recursive(combine + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }

    private boolean isPrime(int num) {
        // 1. 0,1은 소수가 아니다.
        if (num == 0 || num == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit을 계산한다. > 값의 루트값까지만 계산하면 된다.
        // 예) 71 > 루트71 > 8 > limit = 8
        int limit = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 Limit까지만 배수 여부를 확인한다.
        for (int i=2; i<=limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(String numbers) {
        int count = 0;
        // 1. 모든 조합의 값을 set 자료구조로 재귀함수를 이용해 만든다.
        recursive("", numbers);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        final Bruteforce_42839 solution = new Bruteforce_42839();
        int result = solution.solution("17");

        System.out.println(result);
    }
}


