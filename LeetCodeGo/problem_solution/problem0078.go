package problemsolution

func Subsets(nums []int) [][]int {
	result := [][]int{}
	solution := []int{}

	var backtrack func(int)
	backtrack = func(i int) {
		if i == len(nums) {
			temp := make([]int, len(solution))
			copy(temp, solution)
			result = append(result, temp)
			return
		}

		backtrack(i + 1)

		solution = append(solution, nums[i])
		backtrack(i + 1)
		solution = solution[:len(solution)-1]
	}

	backtrack(0)
	return result
}
