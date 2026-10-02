class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] answer = new int[2];
        answer[0]=binarySearch(nums,target, true);
        answer[1]=binarySearch(nums,target, false);
        return answer;
    }

    public int binarySearch(int[] nums, int target, boolean leftbias){
        int l =0;
        int r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            //System.out.println("Mid: "+mid);

            if(nums[mid]==target){
                ans = mid;
                if(leftbias){
                    r = mid-1;
                } else {
                    l = mid+1;
                }
                
            } else if (nums[mid]>target){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }
}