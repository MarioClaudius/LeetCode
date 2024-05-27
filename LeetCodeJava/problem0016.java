package LeetCodeJava;

import java.util.Arrays;

public class problem0016 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));   // should print 2 because -1+2+1=2 is closest to 1
        System.out.println(threeSumClosest(new int[]{1,1,1,0}, 100));   // should print 3 because 1+1+1=3 is closest to 100
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    closestSum = sum;
                    minDiff = diff;
                }

                if (sum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return closestSum;
    }
}
