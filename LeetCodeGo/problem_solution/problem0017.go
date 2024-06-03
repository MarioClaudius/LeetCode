package problemsolution

import "fmt"

func LetterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	result := []string{}
	letterMap := map[byte][]byte{
		'2': {'a', 'b', 'c'},
		'3': {'d', 'e', 'f'},
		'4': {'g', 'h', 'i'},
		'5': {'j', 'k', 'l'},
		'6': {'m', 'n', 'o'},
		'7': {'p', 'q', 'r', 's'},
		'8': {'t', 'u', 'v'},
		'9': {'w', 'x', 'y', 'z'},
	}

	backtrack(&result, len(digits), 0, letterMap, "", digits)
	return result
}

func backtrack(result *[]string, digitCount, currentIndex int, letterMap map[byte][]byte, combinationStr, digits string) {
	if currentIndex == digitCount {
		*result = append(*result, combinationStr)
		return
	}

	for _, char := range letterMap[digits[currentIndex]] {
		backtrack(result, digitCount, currentIndex+1, letterMap, fmt.Sprintf("%s%s", combinationStr, string(char)), digits)
	}
}
