class Solution {
    public int uniquePaths(int m, int n) {
        
        int count =0; 
        if(m<0 || n<0){
            return count;
        }
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1]=1;
        //System.out.println(Arrays.deepToString(dp));
        
        for (int i =m-1; i>=0;i--){
            for(int j =n-1; j>=0; j--){
                dp[i][j]= dp[i][j]+dp[i+1][j]+dp[i][j+1];
                //System.out.println(Arrays.deepToString(dp));
            }
        }
        return dp[0][0];
        //return countPath(m-1, n-1, 0, 0);
    }

    public int countPath(int targetx, int targety, int curx, int cury){
        //System.out.println("curx: "+curx+" cury:"+cury);
        
        if (targetx==curx && targety == cury){
            return 1;
        }
        if (curx>targetx || cury>targety){
            return 0;
        }
        return countPath(targetx, targety, curx+1,cury)+countPath(targetx, targety, curx,cury+1); 
    }
}
