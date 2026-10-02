class Solution {
    public int numDecodings(String s) {
        // if(s.length()<1){
        //     return s.length();
        // }
        // int count=(Integer.parseInt(s.charAt(0)+"")==0)?0:1;
        // for(int i =1; i<s.length(); i++){
        //     int cur = Integer.parseInt(s.charAt(i)+"");
        //     if(cur==0){
        //         if (i!=s.length()-1){
        //             count--;
        //         }
        //         System.out.println("Current count: "+ count);
        //         continue;
        //     }
        //     int prev = Integer.parseInt(s.charAt(i-1)+"");
        //     int couple = (prev*10)+cur;
        //     if(couple>=10 && couple<=26){
        //         count++;
        //         System.out.println("count increased");
        //     }
        //     System.out.println("couple: "+couple);
        // }
        int[] total = new int[s.length()+1];
        total[s.length()]=1;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                total[i]=0;
            } else {
                total[i]= total[i+1];

                // check next val
                if(i!=s.length()-1){
                    int cur = Integer.parseInt(s.charAt(i)+"");
                    int next = Integer.parseInt(s.charAt(i+1)+"");
                    int couple = (cur*10)+next;
                    if(couple>=10 && couple<=26){
                        total[i]+= total[i+2];
                    }
                }
                
            }
        }

        //System.out.println(Arrays.toString(total));
        return total[0];
    }
}
