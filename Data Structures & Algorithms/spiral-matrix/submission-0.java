class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> output = new ArrayList<>();
       int left = 0; 
       int right = matrix[0].length;
       int top = 0;
       int bottom =  matrix.length;

       while (left<right && top<bottom){
        // left->right
        for(int i =left; i<right;i++){
            output.add(matrix[top][i]);
        }
        top++;
        //top->bottom
        for(int i =top; i<bottom; i++){
            output.add(matrix[i][right-1]);
        }
        right--;

        if (!(left < right && top < bottom)) {
                break;
            }

        // right to left
        for(int i= right-1; i>=left; i--){
            output.add(matrix[bottom-1][i]);
        }
        bottom--;
        
        // bottom to top;
        for(int i = bottom-1; i>=top; i--){
             output.add(matrix[i][left]);
        }
        left++;

       }
       return output;
    }
}
