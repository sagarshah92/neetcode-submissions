class Solution {
    public int maxWidthRamp(int[] nums) {
        int length = nums.length;
        int[][] rightmax = new int[length][2];
        rightmax[length-1][0]= nums[length-1];
        rightmax[length-1][1] = length-1;

        for(int i = length-2; i>=0; i--){
            if(rightmax[i+1][0]>=nums[i]){
                rightmax[i][0]= rightmax[i+1][0];
                rightmax[i][1]= rightmax[i+1][1];
            } else{
                rightmax[i][0]= nums[i];
                rightmax[i][1]= i;
            }
        }
    
        int l=0;
        int r=1;
        int ans=0;
        while(r<length){
            //System.out.println("L:"+l +" R: "+r);
            if(rightmax[r][0]>=nums[l]){
                ans = Math.max(r-l, ans);
                r++;
            } else{
                l++;
            }
        }

        //System.out.println(Arrays.deepToString(rightmax));
        return ans;
    }
}
