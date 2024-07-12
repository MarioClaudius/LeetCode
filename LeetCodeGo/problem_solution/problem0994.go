package problemsolution

// still invalid solution for certain test case
func OrangesRotting(grid [][]int) int {
	freshCount := 0
	rottenList := []int{}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				freshCount++
				continue
			}
			if grid[i][j] == 2 {
				rottenList = append(rottenList, (i*10)+j)
			}
		}
	}

	if freshCount == 0 {
		return 0
	}

	minuteCount := 0
	for len(rottenList) > 0 {
		spreadedRottenList := []int{}
		for _, rottenOrangePosition := range rottenList {
			x := rottenOrangePosition / 10
			y := rottenOrangePosition % 10

			if x != 0 {
				if grid[x-1][y] == 1 {
					grid[x-1][y] = 2
					freshCount--
					spreadedRottenList = append(spreadedRottenList, ((x-1)*10)+y)
				}
			}
			if y != 0 {
				if grid[x][y-1] == 1 {
					grid[x][y-1] = 2
					freshCount--
					spreadedRottenList = append(spreadedRottenList, (x*10)+(y-1))
				}
			}
			if x != len(grid)-1 {
				if grid[x+1][y] == 1 {
					grid[x+1][y] = 2
					freshCount--
					spreadedRottenList = append(spreadedRottenList, ((x+1)*10)+y)
				}
			}
			if y != len(grid[0])-1 {
				if grid[x][y+1] == 1 {
					grid[x][y+1] = 2
					freshCount--
					spreadedRottenList = append(spreadedRottenList, (x*10)+(y+1))
				}
			}
		}
		rottenList = []int{}
		rottenList = append(rottenList, spreadedRottenList...)

		minuteCount++
	}

	if freshCount > 0 {
		return -1
	}

	return minuteCount - 1 // didnt count last spread rotten orange
}
