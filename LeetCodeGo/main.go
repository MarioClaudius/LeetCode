package main

import (
	"fmt"
	solution "leetcodego/problem_solution"
)

func main() {
	// Problem 1: Two Sum
	nums := []int{2, 7, 11, 15}
	target := 9
	fmt.Println(solution.TwoSum(nums, target))
}
