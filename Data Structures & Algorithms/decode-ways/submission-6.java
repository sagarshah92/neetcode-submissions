class Solution {
    public int numDecodings(String s) {
        //int[] total = new int[s.length()+1];
        //total[s.length()]=1;

        int dp = 0;
        int dp1 = 1;
        int dp2 = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                dp=0;
            } else {
                dp= dp1;

                // check next val
                if(i!=s.length()-1){
                    int cur = Integer.parseInt(s.charAt(i)+"");
                    int next = Integer.parseInt(s.charAt(i+1)+"");
                    int couple = (cur*10)+next;
                    if(couple>=10 && couple<=26){
                        dp+= dp2;
                    }
                }
                
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
            
        }

        //System.out.println("dp: "+dp+" dp1: "+dp1+" dp2:"+dp2);
        return dp1;
    }
}
