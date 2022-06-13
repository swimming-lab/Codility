package com.swimming.programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 해시
 * Lev.2 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 문제 설명
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 *
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
 * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *
 * 종류	이름
 * 얼굴	동그란 안경, 검정 선글라스
 * 상의	파란색 티셔츠
 * 하의	청바지
 * 겉옷	긴 코트
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 *
 * 입출력 예
 * clothes	return
 * [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
 * [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3
 *
 * 입출력 예 설명
 * 예제 #1
 * headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
 *
 * 1. yellow_hat
 * 2. blue_sunglasses
 * 3. green_turban
 * 4. yellow_hat + blue_sunglasses
 * 5. green_turban + blue_sunglasses
 *
 * 예제 #2
 * face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
 *
 * 1. crow_mask
 * 2. blue_sunglasses
 * 3. smoky_makeup
 */
public class Hash_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;

        // 1. 옷 종류 구분하기, hash에 종류별로 카운팅하기
        // 한 종류 하나만 착용해도 가능하다면, 다른 종류를 착용하지 않는 것도 카운트해야하므로 none값을 꼭 생각하자.
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
//        System.out.println(map);

        // 2. 입지 않는 옷의 경우도 포함해서 모든 조합을 계산
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
//            answer = answer * (iterator.next().intValue() + 1);
            answer *= iterator.next().intValue() + 1;
        }

        // 3. 아무 종류의 옷도 입지 않은 경우는 제외한다.
        return answer - 1;
    }

    public static void main(String[] args) {
        final Hash_42578 solution = new Hash_42578();

        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int result1 = solution.solution(clothes);
        System.out.println(result1);
    }
}


