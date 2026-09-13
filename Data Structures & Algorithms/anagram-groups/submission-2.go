// import (
// 	"slices"
// )
func groupAnagrams(strs []string) [][]string {

	words := make(map [string][]string)
	for _, str := range strs {

		// chars := []rune(str)
		// slices.Sort(chars)
		
		// sortedString := string(chars)
		// if _, contains := words[sortedString]; contains {
		// 	words[sortedString] = append(words[sortedString], str)
		// } else {
		// 	words[sortedString] = []string{str}
		// }
		sortedStr := sortString(str)
		words[sortedStr] = append(words[sortedStr], str)

	}
	output := [][]string {}
	for _, strs := range words {
		output = append(output, strs)
	}
	return output
}


func sortString(str string) string{
	chars := []rune(str)
	sort.Slice(chars, func(a , b int) bool{
		return chars[a]<chars[b]
	})

	return string(chars)
}