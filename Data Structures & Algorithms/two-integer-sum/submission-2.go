
func twoSum(nums []int, target int) []int {


    indices := make(map[int]int)
    for i,n := range nums{
        indices[n] = i
    }
    fmt.Println(indices)
    for i,n := range nums{
        if j,found := indices[target-n]; found && i!=j{
            return []int{i, j}
        }
    }
    return []int{}
}
