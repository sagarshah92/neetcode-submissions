class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        
        int total = dfs(coins, amount);

        return (total==Integer.MAX_VALUE)?-1:total;
    }

    public int dfs(int[] coins, int amount){

        if(amount==0){
            return 0;
        }

        if(map.containsKey(amount)){
            return map.get(amount);
        }
        
        int total = Integer.MAX_VALUE;
        for(int i: coins){
            if(amount-i>=0){
                int subtotal = dfs(coins, amount-i);

                if(subtotal!=Integer.MAX_VALUE){
                    total = Math.min(total, 1+subtotal);
                }
            }
        }
        map.put(amount, total);
        return total;
    }
}
