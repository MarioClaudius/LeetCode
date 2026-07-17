package LeetCodeJava;

public class problem0045 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{1,2}));
        System.out.println(jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
        System.out.println(jump(new int[]{1,2,1,1,1}));
        System.out.println(jump(new int[]{1,1,1,1}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

    // Greedy (find the next index with furthest possible index)
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int currentIndex = 0;
        int currentJumpCount = 0;
        while (currentIndex <= nums.length-1) {
            int jumpLength = nums[currentIndex];
            if (currentIndex + jumpLength >= nums.length-1) {
                currentJumpCount++;
                break;
            }
            int furthestIndex = currentIndex;
            int nextCurrentIndex = currentIndex;
            for(int i = 1; i <= jumpLength; i++) {
                int currentFurthestIndex = currentIndex + i + nums[currentIndex + i];
                if (i == 1 || currentFurthestIndex > furthestIndex) {
                    furthestIndex = currentFurthestIndex;
                    nextCurrentIndex = currentIndex + i;
                }
            }
            currentIndex = nextCurrentIndex;
            currentJumpCount++;
        }

        return currentJumpCount;
    }

    public static int jumpFailGreedy(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int currentIndex = 0;
        int currentJumpCount = 0;
        while(currentIndex + nums[currentIndex] < nums.length-1) {
            int maxJumpLength = 0;
            int maxJumpLengthIndex = currentIndex;
            for(int i = 1; i <= nums[currentIndex]; i++) {
                int checkIndex = currentIndex + i;
                if (i == 1 || nums[checkIndex] >= maxJumpLength) {
                    maxJumpLength = nums[checkIndex];
                    maxJumpLengthIndex = checkIndex;
                }
            }
            currentIndex = maxJumpLengthIndex;
            currentJumpCount++;
        }

        return currentJumpCount+1;
    }

    // bruteforce: time limit issue
    public static int jump2(int[] nums) {
        int[] minimumJump = new int[]{nums.length - 1};
        backtrack(0, 0, nums, minimumJump);
        return minimumJump[0];
    }

    public static void backtrack(int currentIndex, int currentJumpCount, int[] nums, int[] minimumJump) {
        if (currentIndex == nums.length-1) {
            if (currentJumpCount < minimumJump[0]) {
                minimumJump[0] = currentJumpCount;
            }
            return;
        }

        for(int i = 1; i <= nums[currentIndex] && currentIndex+i < nums.length; i++) {
            currentJumpCount++;
            backtrack(currentIndex+i, currentJumpCount, nums, minimumJump);
            currentJumpCount--;
        }
    }
}
