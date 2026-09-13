class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length ==0){
            return -1;
        }

        int max = nums[0];
        int cursum = 0;
        for (int i =0; i<nums.length; i++){
            if (cursum<0){
                cursum = 0;
                // max = Math.max(max, cursum);
                // continue;
            }
            cursum += nums[i];
            max = Math.max(max, cursum);

        }
        return max;
    }
}
