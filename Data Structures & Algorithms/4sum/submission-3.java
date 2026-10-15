class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                    continue;
            }
            for(int j =i+1; j<nums.length;j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                long total = nums[i]+nums[j];
                
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    long stotal = nums[l]+nums[r];
                    if(total+stotal>target){
                        r--;
                    } else if(total+stotal<target){
                        l++;
                    } else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[l]);
                        ans.add(nums[r]);
                        output.add(ans);
                        l++;
                        r--;
                        while(l<r && nums[l-1]==nums[l]){
                            l++;
                        }
                        // while(l<r && nums[r+1]==nums[r]){
                        //     r--;
                        // }
                    }
                }
            }
        }

        System.out.println(output);
        return output;
    }
}