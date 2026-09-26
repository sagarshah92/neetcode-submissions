class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min= 1;
        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i: piles){
            if(i>=max){
                max =i;
            }
        }
        while(min<=max){
            int count=0;
            int mid = min+(max-min)/2;
            for(int i:piles){
                count += Math.ceilDiv(i,mid);
            }
            if(count<=h){
                ans = Math.min(ans, mid);
                max = mid-1;
            } else{
                min = mid+1;
            }
        }

        return ans;

    }
}
