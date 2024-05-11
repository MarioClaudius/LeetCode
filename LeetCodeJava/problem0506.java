package LeetCodeJava;

import java.util.*;

public class problem0506 {
    public static void main(String[] args) {
        int[] score = new int[]{10, 3, 8, 9, 4};
        String[] answerList = findRelativeRanks(score);
        System.out.print("[ ");
        for (String string : answerList) {
            System.out.print(string + " ");
        }
        System.out.println(" ]");
    }

    public static String[] findRelativeRanks(int[] score) {
        List<Integer> scoreOrder = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            if (scoreOrder.size() == 0) {
                scoreOrder.add(score[i]);
            } else {
                boolean positionFound = false;
                int currentScore = score[i];
                for(int j = 0; j < scoreOrder.size(); j++) {
                    if (currentScore > scoreOrder.get(j)) {
                        scoreOrder.add(j, currentScore);
                        positionFound = true;
                        break;
                    }
                }
                if (!positionFound) {
                    scoreOrder.add(currentScore);
                }
            }
        }

        Map<Integer, String> scoreRankMap = new HashMap<>();
        for(int k = 0; k < scoreOrder.size(); k++) {
            if (k == 0) {
                scoreRankMap.put(scoreOrder.get(k), "Gold Medal");
            } else if(k == 1) {
                scoreRankMap.put(scoreOrder.get(k), "Silver Medal");
            } else if(k == 2) {
                scoreRankMap.put(scoreOrder.get(k), "Bronze Medal");
            } else {
                scoreRankMap.put(scoreOrder.get(k), String.valueOf(k+1));
            }
        }

        List<String> result = new ArrayList<>();
        for(int m = 0; m < score.length; m++) {
            result.add(scoreRankMap.get(score[m]));
        }
        return result.toArray(String[]::new);
    }
}
