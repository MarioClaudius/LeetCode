package LeetCodeJava;

import java.util.*;

public class problem0846 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));   // should return true, can be divided to [1,2,3],[2,3,4],[6,7,8]
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5}, 4));   // should return false
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        for(int i = 0; i < hand.length; i++) {
            if (hand[i] != -1) {
                int minimum = hand[i];
                int count = 1;
                int j = i + 1;
                while(j < hand.length && count < groupSize) {
                    if (hand[j] == minimum + count) {
                        hand[j] = -1;
                        count++;
                    }
                    j++;
                }

                if (count != groupSize) {
                    return false;
                }
            }
        }
        return true;
    }
}
