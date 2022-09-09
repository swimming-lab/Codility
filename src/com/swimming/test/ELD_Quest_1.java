package com.swimming.test;

import java.util.*;

/**
 * 알파벳이 적힌 카드 24장이 한 줄에 8장씩, 세 줄로 놓여 있습니다.
 * 같은 알파벳이 적힌 카드가 여러 장 있을 수 있으나, 같은 알파벳이 적힌 카드는 반드시 같은 줄에 놓여 있습니다.
 *
 * 어떤 단어들이 주어질 떄, 각 단어를 주어진 카드로 만들 수 있는지 판별하려고 합니다.
 * 단, 주어진 카드로 만들 때는 반드시 한 줄에 한 카드는 사용해야 합니다.
 */
public class ELD_Quest_1 {
    public String[] solution(String[] cards, String[] words) {
        List<String> answerList = new ArrayList<>();

        for (String word : words) {
//            List<String> copyCardList = new ArrayList<>();
//            for (String card : cards) {
//                copyCardList.add(String.copyValueOf(card.toCharArray()));
//            }
            boolean[] useds = new boolean[cards.length];
            Arrays.fill(useds, Boolean.FALSE);
            String checkWord = "";
            Map<String, Integer> checkMap = new HashMap<>();
            Map<Integer, String> copyCardsMap = new HashMap<>();

            for (char wc : word.toCharArray()) {
                for (int i=0; i<cards.length; i++) {
                    if (!copyCardsMap.containsKey(i)) {
                        copyCardsMap.put(i, String.copyValueOf(cards[i].toCharArray()));
                    }

                    int findIndex = copyCardsMap.get(i).indexOf(wc);
                    String key = i + "_" + findIndex;
                    if (findIndex > -1 && !checkMap.containsKey(key)) {
                        checkMap.put(key, 1);
                        copyCardsMap.put(i, copyCardsMap.get(i).replaceFirst(String.valueOf(wc), "_"));
                        checkWord += wc;
                        useds[i] = true;
                        break;
                    }
                }
            }

            boolean allUsed = true;
            for (boolean used : useds) {
                allUsed &= used;
            }

            if (checkWord.equals(word) && allUsed) {
                answerList.add(word);
            }
        }

        if (answerList.size() == 0) {
            return new String[]{"-1"};
        } else {
            return answerList.toArray(new String[answerList.size()]);
        }
    }

    public static void main(String[] args) {
        final ELD_Quest_1 solution = new ELD_Quest_1();
        String[] result = solution.solution(
                new String[]{"ABACDEFG", "NOPQRSTU", "HIJKLKMM"},
                new String[]{"GPQM", "GPMZ", "EFU", "MMNA"});

        System.out.println(Arrays.toString(result));
    }
}
