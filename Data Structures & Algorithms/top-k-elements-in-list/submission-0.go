// import (
// 	"slices"
// )
func topKFrequent(nums []int, k int) []int {
 
 counts := make(map[int]int)

 for _, num := range nums {
	counts[num]++
 }
 arr := [][2]int{}
 for key , val := range counts {
	 arr = append(arr, [2]int{val, key})
 }

 // sort array
 sort.Slice(arr, func(a,b int) bool{
	return arr[a][0] > arr[b][0]
 })

 output := make([]int, k)
 for i := 0; i<k; i++{
	output[i] = arr[i][1]
 }
 return output
}
