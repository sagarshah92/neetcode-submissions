class Solution {
    public int reverse(int x) {
        long ans = 0;
        long tempx = Math.abs(x);
        //System.out.println(tempx);

        while(tempx>0){
          ans = (ans*10)+(tempx%10);
          tempx = tempx/10;
          //System.out.println(ans+" "+tempx);
        }
        ans = (x<0)? ans*-1 : ans;
        if((ans<Integer.MIN_VALUE) || ans>Integer.MAX_VALUE){
            return 0;
        }
        return (int)ans;
    }
}
