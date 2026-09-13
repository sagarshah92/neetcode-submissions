class Solution {
    public int[] productExceptSelf(int[] nums) {
        // forward multiplier
        int[] forMul = new int[nums.length];
        int[] backMul = new int[nums.length];
        int curmul = 1;
        int curbackMul = 1;
        for (int i =0; i<nums.length; i++){
            forMul[i]= curmul;
            backMul[nums.length-i-1]= curbackMul;
            curmul *=nums[i];
            curbackMul *=nums[nums.length-i-1];
        }

        // // backward multiplier
       
        // int curBackMul = 1;
        // for (int i = nums.length-1; i>=0; i--){
        //     backMul[i]= curBackMul;
        //     curBackMul *=nums[i];
        // }
        // System.out.println(Arrays.toString(forMul));
        // System.out.println(Arrays.toString(backMul));

        int[] output = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            output[i]= forMul[i]*backMul[i];
        }
        return output;
    }
}  
