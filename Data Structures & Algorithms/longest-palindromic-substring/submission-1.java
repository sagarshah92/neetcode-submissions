class Solution {
    public String longestPalindrome(String s) {
        if (s== null || s.length()<2){
            return s;
        }

        int max =0;
        String answer = "";

        for(int i =0; i<s.length(); i++){
            String lenegtho = expandAroundCenter(s, i, i);
            //System.out.println("Index: "+i+" lengtho: "+lenegtho);
            String lengthe= expandAroundCenter(s, i, i+1);
           // System.out.println("Index: "+i+" lengthe: "+lengthe);
            if(lenegtho.length()>max){
                max= lenegtho.length();
                answer = lenegtho;
            }

            if(lengthe.length()>max){
                max= lengthe.length();
                answer = lengthe;
            }

        }
        return answer;
    }

    public String expandAroundCenter(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }
}
