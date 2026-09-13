class NumMatrix {

    int[][] rowsum;
    public NumMatrix(int[][] matrix) {
        rowsum = new int[matrix.length][matrix[0].length];

        for (int r=0; r<matrix.length; r++){
            for(int c =0; c<matrix[0].length; c++){
                if (r==0 && c==0){
                     rowsum[r][c] = matrix[r][c];
                } else if (r==0){
                    rowsum[r][c] = rowsum[r][c-1]+matrix[r][c];
                } else if (c==0){
                    rowsum[r][c] = rowsum[r-1][c]+matrix[r][c];
                } else{
                    rowsum[r][c] = rowsum[r-1][c] + rowsum[r][c-1]+matrix[r][c]-rowsum[r-1][c-1];
                }
                
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int total= rowsum[row2][col2];

        if (row1>0){
            total = total -rowsum[row1-1][col2];
        }
        if (col1>0){
            total =total -rowsum[row2][col1-1];
        }
        if (row1>0 && col1>0){
            total+= rowsum[row1-1][col1-1];
        }
        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
// NumMatrix obj = new NumMatrix(matrix);
 