package com.swimming.test;

import java.util.*;

/**
 * 평가 항목
 * - 동료로서 같이 일하기 좋은 코드를 작성하는가
 * - 컬렉션을 잘 다룰 수 있는가
 * - 논리를 단순화 할 수 있는가
 * - 부수효과(side-effects)를 갖지 않는 코드를 작성할 수 있는가
 *
 * 주의 사항
 * - 외부 도구를 사용해 문제를 푼 후 붙여넣으면 제한시간 치팅으로 간주합니다. 처음부터 끝까지 코딩 테스트 편집기를 사용하고 주기적으로 코드를 실행해 결과를 확인해주세요.
 *
 * 문제
 * list 목록과 count 를 입력받아 count 만큼 요소들을 왼쪽 회전 이동된 목록을 반환하는 함수를 구현해주세요.
 * 단, 입력된 목록은 변하지 않아야 합니다.
 *
 * 조건
 * 문제와 동일하거나 유사한 플랫폼 제공 기능을 사용하지 않아야 합니다.
 * 입력된 목록은 변하지 않아야 합니다.
 *
 * list 의 크기보다 작은 0과 같거나 큰 count를 입력받아 회전된 값을 반환합니다.
 * - 입력: list = [1, 2, 3, 4, 5], count = 2
 * - 출력: [3, 4, 5, 1, 2]
 *
 * list 의 크기보다 큰 count 를 입력받아 회전된 값을 반환합니다.
 * - 입력: list = [1, 2, 3, 4, 5], count = 8
 * - 출력: [4, 5, 1, 2, 3]
 *
 * 0 보다 작은 count 를 입력받아 회전된 값을 반환합니다.
 * - 입력: list = [1, 2, 3, 4, 5], count = -1
 * - 출력: [5, 1, 2, 3, 4]
 */
public class HP_Quest_2 {
    public static void main(String[] args) {
        rotateList(Arrays.asList(1, 2, 3, 4, 5), 2);    // 간단하게 왼쪽 이동이기 때문에 오른쪽 이동하는 값을 얻으면 됨, 고로 size - shift 하면 오른쪽으로 이동하는 횟수를 얻을 수 있음
        rotateList(Arrays.asList(1, 2, 3, 4, 5), 8);    // size - shift하면 -값이 나온다. -값을 절대값으로 바꿔 다시 size - shift하면 위와 동일하게 오른쪽으로 이동하는 횟수를 얻을 수 있음
        rotateList(Arrays.asList(1, 2, 3, 4, 5), -1);   // size + shift하면 +값이 나온다. 그럴 경우 그 값으로 shift % size해서 나오는 나머지값이 오른쪽으로 이동하는 횟수가 된다.
//        assert rotateList(Arrays.asList(1, 2, 3, 4, 5), 2).equals(Arrays.asList(3, 4, 5, 1, 2)) : "list: [1, 2, 3, 4, 5], count: 2";
//        assert rotateList(Arrays.asList(1, 2, 3, 4, 5), 8).equals(Arrays.asList(4, 5, 1, 2, 3)) : "list: [1, 2, 3, 4, 5], count: 8";
//        assert rotateList(Arrays.asList(1, 2, 3, 4, 5), -1).equals(Arrays.asList(5, 1, 2, 3, 4)) : "list: [1, 2, 3, 4, 5], count: -1";
    }

    private static List<Integer> rotateList(List<Integer> numbers, int shift) {
        int[] newArray = new int[numbers.size()];
        int size = numbers.size();

        shift = size - shift;
        if (shift < 0) {
            shift = size - Math.abs(shift);
        } else if (shift > size) {
            shift = shift % size;
        }

        for (int i=0; i<size; i++) {
            int position = i + shift;   // 오른쪽으로 이동할 자리
            if (position >= size) {
                position -= size;   // 이동할 자리가 size보다 크면 앞으로 돌아와야하니 size를 빼면 앞으로 온다.(예: postion(6)-size(5)=1)
            }
            newArray[position] = numbers.get(i);
        }
        System.out.println(Arrays.toString(newArray));
        List<Integer> newList = new ArrayList<>();
        for (int num : newArray) {
            newList.add(num);
        }

        return newList;
    }
}