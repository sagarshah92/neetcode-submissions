class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length-1;
        while(l<r){

            int m = l +(r-l)/2;

            //System.out.println("l: "+l+" r: "+r+" m: "+m);
            if(nums[m]==target){
                return m;
            } else if(nums[m]>=nums[l]){
                // left side is sorted
                //System.out.println("call if ");
                if(target<nums[m] && target>=nums[l]){
                    r=m-1;
                } else {
                    l= m+1;
                }
            } else if (nums[m]<=nums[r]) {
                // right side sorted
                //System.out.println("call else if ");
                if(target>nums[m]&& target<=nums[r]){
                    l = m+1;
                } else{
                    r=m-1;
                }

            }
        }
        //System.out.println("l: "+l+" r: "+r);
        return (nums[l]==target)?l:-1;
    }
}
