class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // first binary search on last collumn
        int t =0;
        int b = matrix.length-1;

        while (t<=b && b-t>1){
            int mid = t +(b-t)/2;
            if (matrix[mid][matrix[0].length-1]== target){
                return true;
            } else if (target>matrix[mid][matrix[0].length-1]){
                t= mid;
            } else {
                b = mid;
            }
        }

        //System.out.println("Final t: "+t+" Final b: "+b);
        int targetrow = -1;

        if (target>matrix[t][matrix[0].length-1]){
            targetrow= b;
        } else {
            targetrow= t;
        }
        //System.out.println("target row: "+targetrow);

        int l =0;
        int r = matrix[targetrow].length-1;
       //System.out.println("l: "+l+" r: "+r);
        while (l<=r){
            int mid = l+(r-l)/2;
            //System.out.println("l: "+l+" r: "+r+" mid: "+mid);
            if (matrix[targetrow][mid]==target){
                return true;
            } else if (matrix[targetrow][mid]> target){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
    return false;
    }
}
