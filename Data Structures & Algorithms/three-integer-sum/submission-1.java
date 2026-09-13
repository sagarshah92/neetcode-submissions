class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for (int i =0; i<nums.length; i++){
            if(nums[i]>0){
                break;
            }
            if (i>0 && nums[i]==nums[i-1] ){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum>0){
                    r--;
                } else if (sum<0){
                    l++;
                } else{
                    List<Integer> templist = new ArrayList<>();
                    templist.add(nums[i]);
                    templist.add(nums[l]);
                    templist.add(nums[r]);
                    output.add(templist);

                    l++;
                    r--;
                    while (l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }
        }
        return output;
    }
}
