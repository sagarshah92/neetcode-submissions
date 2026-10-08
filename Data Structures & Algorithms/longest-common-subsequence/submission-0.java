class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int row =m-1; row>=0; row--){
            for(int col =n-1; col>=0; col--){
                if(text1.charAt(row)==text2.charAt(col)){
                    dp[row][col]= 1+dp[row+1][col+1];
                } else{
                    dp[row][col] = Math.max(dp[row+1][col], dp[row][col+1]);
                }
            }
        }
        return dp[0][0];
    }
}
