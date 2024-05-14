package problemsolution

import (
	"sort"
)

// ACCEPTED SOLUTION USING 2 POINTER
func ThreeSum(nums []int) [][]int {
	// sort the array first
	sort.Ints(nums)
	result := make([][]int, 0)
	for index, value := range nums {
		if index > 0 && nums[index] == nums[index-1] {
			continue
		}
		target := -1 * value
		leftIndex := index + 1
		rightIndex := len(nums) - 1
		for leftIndex < rightIndex {
			if nums[leftIndex]+nums[rightIndex] == target {
				solution := []int{nums[index], nums[leftIndex], nums[rightIndex]}
				result = append(result, solution)
				increment := 1
				for leftIndex+increment < len(nums)-1 && nums[leftIndex+increment] == nums[leftIndex] {
					increment++
				}
				leftIndex += increment
			}
			if nums[leftIndex]+nums[rightIndex] > target {
				rightIndex--
			} else {
				leftIndex++
			}
		}
	}
	return result
}

// TIME LIMIT EXCEEDED SOLUTION, USING NORMAL LOOP (308/313 test case passed)
func ThreeSum1(nums []int) [][]int {
	result := make([][]int, 0)
	if len(nums) == 3 {
		sum := 0
		for i := 0; i < len(nums); i++ {
			sum += nums[i]
		}

		if sum == 0 {
			result = append(result, nums)
		}

		return result
	}

	// for edge case when there's 3 zero in array
	zeroNumCount := 0
	for a := 0; a < len(nums); a++ {
		if nums[a] == 0 {
			zeroNumCount++
		}
	}

	if zeroNumCount >= 3 {
		result = append(result, []int{0, 0, 0})
	}

	for i := 0; i < len(nums)-2; i++ {
		firstNum := nums[i]
		targetSum := -1 * firstNum
		secondNumMap := make(map[int]int, 0)
		for j := i + 1; j < len(nums); j++ {
			currentValue := nums[j]
			if _, ok := secondNumMap[currentValue]; !ok {
				secondNumMap[currentValue] = j
			}
		}

		for k := i + 2; k < len(nums); k++ {
			if value, valid := secondNumMap[targetSum-nums[k]]; valid && value != k {
				solution := []int{firstNum, targetSum - nums[k], nums[k]}
				isSameSolution := false
				for _, solutionResult := range result {
					setMap := make(map[int]bool, 0)
					for i := 0; i < len(solutionResult); i++ {
						setMap[solutionResult[i]] = true
					}
					isExistOnSet := true
					for i := 0; i < len(solution); i++ {
						_, exist := setMap[solution[i]]
						isExistOnSet = isExistOnSet && exist
					}
					if isExistOnSet {
						isSameSolution = true
						break
					}
				}
				if !isSameSolution {
					result = append(result, solution)
				}
			}
		}
	}

	return result
}
