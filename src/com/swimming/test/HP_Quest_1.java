package com.swimming.test;

/**
 * 안녕하세요. 힐링페이퍼 코딩테스트입니다.
 * 제한시간은 60분이며, 기본 언어는 Java로 되어있지만 본인이 편한 언어로 바꿔서 풀어도 좋습니다.
 *
 * 평가 항목
 * - 동료로서 같이 일하기 좋은 코드를 작성하는가
 * - 문자열을 반복하면서 경계조건, 예외 상황 등을 잘 처리할 수 있는가
 *
 * 주의 사항
 * - 외부 도구를 사용해 문제를 푼 후 붙여넣으면 제한시간 치팅으로 간주합니다. 처음부터 끝까지 코딩 테스트 편집기를 사용하고 주기적으로 코드를 실행해 결과를 확인해주세요.
 *
 * 문제
 * 문자열로 표현된 정수를 정수값으로 변환하는 함수를 작성해주세요.
 *
 * 조건
 * 문제와 동일하거나 유사한 플랫폼 제공 기능을 사용하지 않아야 합니다. parse... 함수나 형 변환 등이 여기에 포함됩니다.
 *
 * 문자열의 내용이 양의 정수인 경우 정수값으로 변환한 값을 변환합니다.
 * - 입력: "123"
 * - 출력: 123
 *
 * 문자열의 내용이 정수가 아닌 경우는 null 을 반환합니다.
 * - 입력: "123.456"
 * - 출력: null
 *
 * 문자열의 내용이 음의 정수인 경우 정수값으로 변환한 값을 반환합니다.
 * - 입력: "-123"
 * - 출력: -123
 */
public class HP_Quest_1 {
    public static void main(String[] args) {
        stringToInteger("123");
        stringToInteger("123.456");
        stringToInteger("-123");
//        assert stringToInteger("123") == 123 : "123";
//        assert stringToInteger("123.456") == null : "123.456";
//        assert stringToInteger("-123") == -123 : "-123";
    }

    private static Integer stringToInteger(String str) {
        if (str.indexOf(".") > -1) {
            System.out.println("null");
            return null;
        }

        boolean isNegative = false;
        if (str.startsWith("-")) {
            isNegative = true;
            str = str.substring(1);
        }

        char[] chars = str.toCharArray();
        int num = 0;
        for (int i=0; i< chars.length; i++) {
            int digit = 1;
            for (int j=i+1; j<chars.length; j++) {
                digit *= 10;
            }

            num += Character.getNumericValue(chars[i]) * digit;
        }

        if (isNegative) {
            num *= -1;
        }
        System.out.println(num);
        return num;
    }
}


