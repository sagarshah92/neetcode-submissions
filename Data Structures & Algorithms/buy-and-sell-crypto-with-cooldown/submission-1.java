class Solution {
    Map<String, Integer> map;

    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] row: dp){
             Arrays.fill(row, -1);
        }
        System.out.println(Arrays.deepToString(dp));
       
        int profit = calculateMaxProfit(prices, 0, 0);
        return profit;
    }

    public int calculateMaxProfit(int[] prices, int index, int buying){

        if(index>=prices.length){
            return 0;
        }

        if(dp[index][buying]!=-1){
            return dp[index][buying];
        }
        // buying
        int cooldown = calculateMaxProfit(prices, index+1, buying);
        if(buying==0){
            int buy = calculateMaxProfit(prices, index+1, 1)-prices[index];
            dp[index][buying] = Math.max(buy, cooldown);
            //map.put(index+"-"+buying, );
        } else{
            int sell = calculateMaxProfit(prices, index+2, 0)+prices[index];
            //int cooldown = calculateMaxProfit(prices, index+1, false);
            //map.put(index+"-"+buying, Math.max(sell, cooldown));
            dp[index][buying] = Math.max(sell, cooldown);
        }
        //System.out.println(Arrays.deepToString(dp));

        return dp[index][buying];

    }
}
