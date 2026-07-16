package LeetCodeJava;

import java.util.HashMap;

public class problem0055 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        int nearestPossibleIndex = nums.length-1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nearestPossibleIndex - i) {
                nearestPossibleIndex = i;
            }
        }
        return nearestPossibleIndex == 0;
    }

    public static boolean canJump2(int[] nums) {
        HashMap<Integer, Boolean> indexCanReachLastIndexMap = new HashMap<>();
        indexCanReachLastIndexMap.put(nums.length-1, true);
        return backtrack(0, nums[0], nums, indexCanReachLastIndexMap);
    }

    // brute force with memoization
    public static boolean backtrack(int currentIndex, int maxJumpLength, int[] nums, HashMap<Integer, Boolean> indexCanReachLastIndexMap) {
        // base case
        if (indexCanReachLastIndexMap.containsKey(currentIndex)) {
            return indexCanReachLastIndexMap.get(currentIndex);
        }
        if (maxJumpLength == 0) {
            indexCanReachLastIndexMap.put(currentIndex, false);
            return false;
        }

        for(int i = 1; i <= maxJumpLength && currentIndex + i < nums.length; i++) {
           if (backtrack(currentIndex+i, nums[currentIndex+i], nums, indexCanReachLastIndexMap)) {
                indexCanReachLastIndexMap.put(currentIndex, true);
                return true;
           }
        }

        indexCanReachLastIndexMap.put(currentIndex, false);
        return false;
    }

    // brute force
    public static boolean backtrack2(int currentIndex, int maxJumpLength, int[] nums) {
        // base case
        if (currentIndex == nums.length-1) {
            return true;
        }
        if (maxJumpLength == 0) {
            return false;
        }

        for(int i = 1; i <= maxJumpLength && currentIndex + i < nums.length; i++) {
           if (backtrack2(currentIndex+i, nums[currentIndex+i], nums)) {
                return true;
           }
        }

        return false;
    }
}
