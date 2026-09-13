class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();

       
        int ans =0;
        int l=0;
        int max =0;
        for (int r = 0; r<s.length(); r++){
            int currentCount = count.getOrDefault(s.charAt(r), 0);
            count.put(s.charAt(r),currentCount +1);
            max = Math.max(max, count.get(s.charAt(r)));


            while((r-l+1)- max > k){
               count.put(s.charAt(l), count.get(s.charAt(l))-1);
               l++;
              
            }
            ans = Math.max(max, r-l+1);
            //System.out.println("End of loop: "+count);
        }

        return ans;
    }
}
