package com.swimming.programmers;

import java.util.*;

public class Java_30_lessons_92334 {
    /**
     * Lev.1 신고 결과 받기
     */
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, Integer> idMap = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            idMap.put(id_list[i], i);
        }

        List<String> stopedUser = new ArrayList<>();
        Map<String, Map> reportMap = new HashMap<>();
        for (int i=0; i<report.length; i++) {
            String[] res = report[i].split(" ");
            String user = res[0];
            String target = res[1];

            Map<String, Object> rep = null;
            List<String> users = null;

            if (reportMap.containsKey(target)) {
                rep = reportMap.get(target);
                users = (List<String>) rep.get("users");

                if (!users.contains(user)) {
                    int count = (int) rep.get("count")+1;
                    rep.put("count", count);
                    if (count >= k) {
                        stopedUser.add(target);
                    }

                    users.add(user);
                    rep.put("users", users);
                }

                reportMap.put(target, rep);
            } else {
                rep = new HashMap<>();
                users = new ArrayList<>();

                users.add(user);
                rep.put("count", 1);
                rep.put("users", users);

                if (k == 1) {
                    stopedUser.add(target);
                }

                reportMap.put(target, rep);
            }
        }

        for (String target : stopedUser) {
            Map<String, Object> rep = reportMap.get(target);
            List<String> users = (List<String>) rep.get("users");

            for (String user : users) {
                answer[idMap.get(user)] += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final Java_30_lessons_92334 solution = new Java_30_lessons_92334();
        int[] result = solution.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2);

        System.out.println(Arrays.toString(result));
    }
}


