class Solution {
    public int search(int[] nums, int target) {
        if (nums.length<1){
            return -1;
        }
        int i = 0;
        int j = nums.length-1;

        while (i<=j){
            int mid = (i+j)/2;
            System.out.println(mid);
            if (nums[mid] == target){
                return mid;
            } else if (target> nums[mid]){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return -1;
    }
}
