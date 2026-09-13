class Solution {
    public int maxProfit(int[] prices) {
        
        //int[] leftmax = new int[prices.length];
        int[] rightmax = new int[prices.length];

        // int curMax = 0;
        // for(int i =0; i<prices.length; i++){
        //     if (prices[i]>curMax){
        //         leftmax[i]= prices[i];
        //     } else {
        //         leftmax[i] = curMax;
        //     }
        // }

        int curMax= 0;
        for(int i =prices.length-1; i>=0; i--){
            rightmax[i]= Math.max(prices[i], curMax);
            curMax =rightmax[i];
        }
        //System.out.println(Arrays.toString(rightmax));
        int maxProfit =0;
        for (int i=0 ; i<prices.length; i++){
            int profit = rightmax[i]-prices[i];
            maxProfit =Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
