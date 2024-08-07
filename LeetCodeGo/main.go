package main

import (
	"fmt"
	solution "leetcodego/problem_solution"
)

func main() {
	// *************************** Problem 1: Two Sum ***************************
	nums := []int{2, 7, 11, 15}
	target := 9
	fmt.Println(solution.TwoSum(nums, target))

	//*************************** Problem 15: 3Sum ***************************
	nums1 := []int{-1, 0, 1, 2, -1, -4}
	nums2 := []int{0, 0, 0}
	nums3 := []int{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}
	nums4 := []int{0, -3, 2, -4, -1, -3, -2, 1, -1, 1, 3}
	fmt.Println(solution.ThreeSum(nums1)) // should print [[-1,-1,2],[-1,0,1]]
	fmt.Println(solution.ThreeSum(nums2)) // should print [[0,0,0]]
	fmt.Println(solution.ThreeSum(nums3)) // should print [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
	fmt.Println(solution.ThreeSum(nums4)) // should print [[-4,1,3],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-2,1,1],[-1,-1,2],[-1,0,1]]

	//*************************** Problem 17: Letter Combination of Phone Number ***************************
	fmt.Println(solution.LetterCombinations("23"))

	//*************************** Problem 46: Permutations ***************************
	fmt.Println(solution.Permute([]int{1, 2, 3}))

	//*************************** Problem 78: Subsets ***************************
	fmt.Println(solution.Subsets([]int{1, 2, 3}))

	//*************************** Problem 409: Longest Palindrome ***************************
	fmt.Println(solution.LongestPalindrome("abccccdd")) // should return 7 because the longest palindrome from that string is dccaccd

	//*************************** Problem 746: Minimum Cost Climbing Stairs ***************************
	fmt.Println(solution.MinCostClimbingStairs([]int{10, 15, 20}))

	//*************************** Problem 994: Rotting Oranges ***************************
	fmt.Println(solution.OrangesRotting([][]int{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}))
	fmt.Println(solution.OrangesRotting([][]int{{2, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 1, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 0, 1, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}))

	//*************************** Problem 1002: Find Common Characters ***************************
	fmt.Println(solution.CommonChars([]string{"bella", "label", "roller"})) // should return ["e", "l", "l"]
}
