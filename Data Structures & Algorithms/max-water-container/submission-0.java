class Solution {
    public int maxArea(int[] heights) {
        
        int max = 0;

        int start = 0;
        int end = heights.length-1;
        while (start<end){
            int curmax = (end-start)*Math.min(heights[start], heights[end]);
            if (curmax>max){
                max = curmax;
            }
            
            if (heights[start]<heights[end]){
                start++;
            } else{
                end--;
            }

        }
        return max;
    }
}
