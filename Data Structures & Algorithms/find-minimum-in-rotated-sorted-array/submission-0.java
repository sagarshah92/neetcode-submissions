class Solution {
    public int findMin(int[] nums) {

        int length = nums.length;
        int l =0;
        int r = length-1;
        
        while(l<r){
            int mid = l +(r-l)/2;
            if (nums[mid]<nums[r]){
                r=mid;
            } else{
                l = mid+1;
            }

        }
        System.out.println("l: "+nums[l]+" r:"+nums[r]);
        return nums[l];
        
    }
}
