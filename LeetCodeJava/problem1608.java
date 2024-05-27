package LeetCodeJava;

import java.util.*;

public class problem1608 {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3, 5}));
    }

    public static int specialArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int specialNum = 1;
        int countOfNumGreaterThanSpecialNum = 0;
        while (specialNum <= nums[nums.length-1]) {
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] >= specialNum) {
                    countOfNumGreaterThanSpecialNum++;
                }
            }

            if (countOfNumGreaterThanSpecialNum == specialNum) {
                return specialNum;
            } else {
                specialNum++;
                countOfNumGreaterThanSpecialNum = 0;
            }
        }
        return -1;
    }
}
