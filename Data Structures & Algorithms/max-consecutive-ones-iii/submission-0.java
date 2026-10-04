class Solution {
    public int longestOnes(int[] nums, int k) {

        int l =0;
        int r =0;
        int max =0;

        while(r<nums.length){
            System.out.println(" l: "+l+" r: "+r+" max: "+max);
            if(nums[r]==1){
                r++;
            } else if (k>0){
                if(nums[r]==0){
                    //System.out.println("call");
                    k--;
                } 
                r++;
            } else{
                while(k==0){
                    if(nums[l]==0){
                        k++;
                    } 
                    l++;
                }
            }

            

            max = Math.max(max, r-l);
        }
        return max;
    }
}