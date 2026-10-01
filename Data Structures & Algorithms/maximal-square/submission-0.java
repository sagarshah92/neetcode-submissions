class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] count = new int[matrix.length][matrix[0].length];
        int answer =0;
        for(int i = rows-1; i>=0; i--){
            for(int j =cols-1; j>=0; j--){
                if(i==rows-1){
                   count[i][j] =  Integer.parseInt(matrix[i][j]+"");
                } else if(j ==cols-1){
                    count[i][j] =  Integer.parseInt(matrix[i][j]+"");
                } else if (matrix[i][j]=='1'){
                    count[i][j] = Math.min(count[i+1][j], Math.min(count[i][j+1], count[i+1][j+1]))+1;
                }
                answer = Math.max(answer, count[i][j]*count[i][j]);

            }
        }

        System.out.println(Arrays.deepToString(count));

        return answer;
    }
}