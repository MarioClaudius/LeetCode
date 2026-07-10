package LeetCodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class problem0018 {
    public static void main(String[] args) {
        print(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        print(fourSum(new int[]{2,2,2,2,2}, 8));
    }
    
    // current solution only 287/294 passed, expected time limit issue since it's bruteforce
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<String, Integer> sum3IndexNumsMap = new HashMap<>();
        int sum3IndexNums = 0;
        List<Integer> indexCombination3Nums = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(nums[i]);
            optimizedBruteForceCheck(nums, target - nums[i], currentList, 4, results, sum3IndexNumsMap, sum3IndexNums, indexCombination3Nums, i+1);
            currentList.removeLast();
        }
        return results;
    }

    public static void optimizedBruteForceCheck(int[] nums, int target, List<Integer> currentList, int maxListCount, List<List<Integer>> results, HashMap<String, Integer> sum3IndexNumsMap, int sum3IndexNums, List<Integer> indexCombination3Nums, int startIndex) {
        for(int i = startIndex; i < nums.length - (maxListCount - (currentList.size()+1)); i++) {
            currentList.add(nums[i]);
            sum3IndexNums += nums[i];
            indexCombination3Nums.add(i);
            
            if (currentList.size() == maxListCount) {
                sum3IndexNumsMap.put(String.format("%d:%d:%d", indexCombination3Nums.get(0), indexCombination3Nums.get(1), indexCombination3Nums.get(2)), sum3IndexNums);
                if (nums[i] == target) {
                    List<Integer> copy = new ArrayList<>(currentList);
                    Collections.sort(copy);
                    boolean identicalExist = false;
                    for(List<Integer> result : results) {
                        if (result.equals(copy)) {
                            identicalExist = true;
                        }
                    }
                    if (!identicalExist) {
                        results.add(copy);
                    }
                }
            } else {
                optimizedBruteForceCheck(nums, target-nums[i], currentList, maxListCount, results, sum3IndexNumsMap, sum3IndexNums, indexCombination3Nums, i+1);
            }
            currentList.removeLast();
            sum3IndexNums -= nums[i];
            indexCombination3Nums.removeLast();
        }
    }

    // current solution only 287/294 passed, expected time limit issue since it's bruteforce
    public static void bruteForceCheck(int[] nums, int target, List<Integer> currentList, int maxListCount, List<List<Integer>> results) {
        for(int i = 0; i < nums.length - (maxListCount - (currentList.size()+1)); i++) {
            currentList.add(nums[i]);
            if (currentList.size() == maxListCount) {
                if (nums[i] == target) {
                    List<Integer> copy = new ArrayList<>(currentList);
                    Collections.sort(copy);
                    boolean identicalExist = false;
                    for(List<Integer> result : results) {
                        if (result.equals(copy)) {
                            identicalExist = true;
                        }
                    }
                    if (!identicalExist) {
                        results.add(copy);
                    }
                }
            } else {
                bruteForceCheck(Arrays.copyOfRange(nums, i+1, nums.length), target-nums[i], currentList, maxListCount, results);
            }
            currentList.removeLast();
        }
    }

    public static void print(List<List<Integer>> result) {
        for(int i = 0; i < result.size(); i++) {
            System.out.print("[ ");
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.printf("%d ", result.get(i).get(j));
            }
            System.out.println("]");
        }
    }
}
