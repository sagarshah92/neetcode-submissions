class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] answer = new int[2];
        answer[0]=-1;
        answer[1]=-1;

        int l =0;
        int r = nums.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            System.out.println("Mid: "+mid);

            if(nums[mid]==target){
                // found it. 
                //we can go left and right
                int al = mid;
                while(al>=0 && nums[al]==target){
                    al--;
                }
                System.out.println("al: "+al);
                answer[0]=al+1;

                int rl = mid;
                while(rl<nums.length && nums[rl]==target){
                    rl++;
                }
                System.out.println("rl: "+rl);
                answer[1]=rl-1;
                return answer;
            } else if (nums[mid]>target){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return answer;
    }
}