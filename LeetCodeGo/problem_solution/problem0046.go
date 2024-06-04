package problemsolution

func Permute(nums []int) [][]int {
	result := [][]int{}
	solution := []int{}
	mapNumContain := map[int]bool{}

	var backtrack func()
	backtrack = func() {
		if len(solution) == len(nums) {
			temp := make([]int, len(nums))
			copy(temp, solution)
			result = append(result, temp)
			return
		}

		for _, num := range nums {
			if exist, ok := mapNumContain[num]; !exist || !ok {
				solution = append(solution, num)
				mapNumContain[num] = true
				backtrack()
				solution = solution[:len(solution)-1]
				mapNumContain[num] = false
			}
		}
	}

	backtrack()
	return result
}
