package com.swimming.test;

/**
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
        if (str.indexOf(".") > -1) {    // 소수점이 있을 경우 Integer가 아니므로 null을 반환
            System.out.println("null");
            return null;
        }

        boolean isNegative = false;
        if (str.startsWith("-")) {  // 첫번째 글자를 확인하여 음수를 체크
            isNegative = true;
            str = str.substring(1); // 첫번째 글자를 제외함(숫자만 남음)
        }

        char[] chars = str.toCharArray();
        int num = 0;
        for (int i=0; i< chars.length; i++) {
            int digit = 1;  // 자릿수
            for (int j=i+1; j<chars.length; j++) {  // j=i+1 > 자신을 제외한 남은 자릿수만큼 10을 곱하면 된다.
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


