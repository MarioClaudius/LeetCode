package main

import (
	"fmt"
	solution "leetcodego/problem_solution"
)

func main() {
	// Problem 1: Two Sum
	// nums := []int{2, 7, 11, 15}
	// target := 9
	// fmt.Println(solution.TwoSum(nums, target))

	// Problem 15: 3Sum
	// nums1 := []int{-1, 0, 1, 2, -1, -4}
	// nums2 := []int{0, 0, 0}
	// nums3 := []int{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}
	nums4 := []int{0, -3, 2, -4, -1, -3, -2, 1, -1, 1, 3}
	// fmt.Println(solution.ThreeSum(nums1)) // should print [[-1,-1,2],[-1,0,1]]
	fmt.Println(solution.ThreeSum(nums4)) // should print [[-4,1,3],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-2,1,1],[-1,-1,2],[-1,0,1]]
}
