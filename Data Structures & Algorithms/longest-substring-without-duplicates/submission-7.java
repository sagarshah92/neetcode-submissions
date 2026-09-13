class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.equals("") || s.isEmpty()){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max =0;
        int l = 0;

        for (int r =0; r<s.length(); r++){
            if (map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r))+1, l);
            }
            map.put(s.charAt(r), r);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
