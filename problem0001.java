public class problem0001 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);    // result = [0, 1] => 2 + 7 = 9
        System.out.printf("[%d, %d]\n", result[0], result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            int secondNum = target - firstNum;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == secondNum) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
