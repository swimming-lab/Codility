package com.swimming.test;

import java.util.*;

public class HH_Quest_3 {

    static final String[] DAY_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    static class CursorCalender {
        int m;
        int d;
        int dow;

        public CursorCalender(String start_date) {
            String startMmdd = start_date.split(" ")[0];
            String startMm = startMmdd.split("/")[0];
            String startDd = startMmdd.split("/")[1];
            String startDow = start_date.split(" ")[1];

            this.m = Integer.parseInt(startMm);
            this.d = Integer.parseInt(startDd);
            for (int i=0; i<DAY_OF_WEEK.length; i++) {
                if (startDow.equals(DAY_OF_WEEK[i])) {
                    this.dow = i;
                    break;
                }
            }
        }

        private int[] calulateCalender(String date) {
            int month = Integer.parseInt((date.split("/")[0]));
            int days = Integer.parseInt((date.split("/")[1]));
            int gapDays = 0;

            if (this.m == month) {
                gapDays = days - this.d;
            } else {
                int end = this.m;

                while (end > month) {
                    int lastDays = getLastDays(end);
                    gapDays += lastDays - days;
                    end++;
                }
            }

            return new int[]{month, days, gapDays};
        }

        public CursorCalender createCalender(String date) {
            int[] calulateCalender = calulateCalender(date);

            int index = (this.dow + calulateCalender[2]) % 7;
            String start_date = calulateCalender[0] + "/" + calulateCalender[1] + " " + DAY_OF_WEEK[index];
            return new CursorCalender(start_date);
        }

        public void setCursorCalender(String date) {
            int[] calulateCalender = calulateCalender(date);

            this.m = calulateCalender[0];
            this.d = calulateCalender[1];
            this.dow = (this.dow + calulateCalender[2]) % 7;
        }

        public boolean isWeekday() {
            return this.dow < 5;
        }

        public int getLastDays(int month) {
            if (month == 4 ||
                    month == 6 ||
                    month == 9 ||
                    month == 11) {
                return 30;
            } else if (month ==2 ) {
                return 28;
            } else {
                return 31;
            }
        }
    }

    public int solution(String start_date, String end_date, String[] login_dates) {
        int answer = -1;

        CursorCalender cursorCalender = new CursorCalender(start_date);

        // login_dates 정렬
        List<String> loginDateList = new ArrayList<>();
        for (String login_date : login_dates) {
            loginDateList.add(login_date);
        }
        Collections.sort(loginDateList);

        int max = 0;
        for (String loginDate : loginDateList) {
            CursorCalender loginCalender = cursorCalender.createCalender(loginDate);

            if (loginCalender.m == cursorCalender.m) {
                if ((loginCalender.isWeekday() && loginCalender.d - cursorCalender.d == 1) ||
                        (loginCalender.isWeekday() && loginCalender.d - cursorCalender.d <= 3 && cursorCalender.dow == 4 && loginCalender.dow == 0)) {
                    // 평일 이어짐
                    cursorCalender.setCursorCalender(loginDate);
                    max++;
                    answer = Math.max(max, answer);
                } else {
                    if (loginCalender.isWeekday()) {
                        // 평일 카운트 시작
                        cursorCalender.setCursorCalender(loginDate);
                        max = 1;
                        answer = Math.max(max, answer);
                    } else {
                        // 주말 카운트 X(초기화)
                        max = 0;
                    }
                }
            } else if (loginCalender.m - cursorCalender.m == 1) {
                int lastDays = cursorCalender.getLastDays(cursorCalender.m);

                if (cursorCalender.d + 1 > lastDays && loginCalender.d == 1 && loginCalender.isWeekday() ||
                        cursorCalender.d + 1 > lastDays && loginCalender.d <= 3 && loginCalender.isWeekday() && cursorCalender.dow == 4 && cursorCalender.dow == 0) {
                    // 평일 이어짐
                    cursorCalender.setCursorCalender(loginDate);
                    max++;
                    answer = Math.max(max, answer);
                } else {
                    if (loginCalender.isWeekday()) {
                        // 평일 카운트 시작
                        cursorCalender.setCursorCalender(loginDate);
                        max = 1;
                        answer = Math.max(max, answer);
                    } else {
                        // 주말 카운트 X(초기화)
                        max = 0;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final HH_Quest_3 solution = new HH_Quest_3();
        String[] login_dates = {"05/26", "05/25", "05/27", "05/10", "05/11", "05/23", "05/22", "05/21", "05/06", "05/09", "05/07", "05/08"};
        int result = solution.solution("05/04 MON", "05/30", login_dates);

        System.out.println(result); // 5
//        System.out.println(Arrays.toString(result));
    }
}



