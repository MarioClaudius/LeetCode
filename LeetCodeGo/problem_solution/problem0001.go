package main

func twoSum(nums []int, target int) []int {
	result := make([]int, 2)
	for i := 0; i < len(nums); i++ {
		firstNum := nums[i]
		secondNum := target - firstNum
		for j := i + 1; j < len(nums); j++ {
			if nums[j] == secondNum {
				result[0] = i
				result[1] = j
				return result
			}
		}
	}

	return result
}
