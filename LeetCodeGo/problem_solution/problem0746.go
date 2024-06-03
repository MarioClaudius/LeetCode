package problemsolution

func MinCostClimbingStairs(cost []int) int {
	minCost := make([]int, len(cost)+1)
	for i := 2; i < len(minCost); i++ {
		if minCost[i-2]+cost[i-2] < minCost[i-1]+cost[i-1] {
			minCost[i] = minCost[i-2] + cost[i-2]
		} else {
			minCost[i] = minCost[i-1] + cost[i-1]
		}
	}
	return minCost[len(cost)]
}
