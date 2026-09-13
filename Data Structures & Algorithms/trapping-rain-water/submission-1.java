class Solution {
    public int trap(int[] height) {
        int total =0;

        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        // find left max height
        leftmax[0]=height[0];

        for (int i =1; i<height.length; i++){
            leftmax[i]= Math.max(leftmax[i-1], height[i]);
        }
        // find right max height;
        rightmax[height.length-1]= height[height.length-1];

        for (int j = height.length-2; j>=0; j--){
            rightmax[j]= Math.max(rightmax[j+1], height[j]);
        }
        // System.out.println(Arrays.toString(leftmax));
        // System.out.println(Arrays.toString(rightmax));
        
        for (int k =0; k<height.length; k++){
            total += Math.min(leftmax[k],rightmax[k])- height[k];
        }
        return total;
    }
}
