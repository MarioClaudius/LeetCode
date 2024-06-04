package problemsolution

func LongestPalindrome(s string) int {
	charCountMap := map[byte]int{}
	for _, character := range s {
		if count, exist := charCountMap[byte(character)]; exist {
			charCountMap[byte(character)] = count + 1
		} else {
			charCountMap[byte(character)] = 1
		}
	}

	longestPalindromeLength := 0
	for _, count := range charCountMap {
		longestPalindromeLength += (count / 2) * 2
	}

	if len(s) == longestPalindromeLength {
		return longestPalindromeLength
	}

	return longestPalindromeLength + 1
}
