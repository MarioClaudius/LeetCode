package problemsolution

func CommonChars(words []string) []string {
	commonCharList := []string{}
	mapCharMinimumCount := map[byte]int{}
	for i, word := range words {
		if i == 0 {
			for _, character := range word {
				if count, ok := mapCharMinimumCount[byte(character)]; !ok {
					mapCharMinimumCount[byte(character)] = 1
				} else {
					mapCharMinimumCount[byte(character)] = count + 1
				}
			}
		} else {
			mapWordCharCount := map[byte]int{}
			for _, character := range word {
				if count, ok := mapWordCharCount[byte(character)]; !ok {
					mapWordCharCount[byte(character)] = 1
				} else {
					mapWordCharCount[byte(character)] = count + 1
				}
			}

			for character, minCount := range mapCharMinimumCount {
				if count, _ := mapWordCharCount[character]; count < minCount {
					mapCharMinimumCount[character] = count
				}
			}
		}
	}

	for character, count := range mapCharMinimumCount {
		for i := 0; i < count; i++ {
			commonCharList = append(commonCharList, string(character))
		}
	}

	return commonCharList
}
