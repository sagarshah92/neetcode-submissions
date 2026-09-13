class Solution {
    public int[] productExceptSelf(int[] nums) {
        // forward multiplier
        int[] forMul = new int[nums.length];
        int curmul = 1;
        for (int i =0; i<nums.length; i++){
            forMul[i]= curmul;
            curmul *=nums[i];
        }

        // backward multiplier
        int[] backMul = new int[nums.length];
        int curBackMul = 1;
        for (int i = nums.length-1; i>=0; i--){
            backMul[i]= curBackMul;
            curBackMul *=nums[i];
        }
        // System.out.println(Arrays.toString(forMul));
        // System.out.println(Arrays.toString(backMul));

        int[] output = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            output[i]= forMul[i]*backMul[i];
        }
        return output;
    }
}  
