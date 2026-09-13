class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.equals("") || s.isEmpty()){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max =0;
        int cur_start = 0;
        int runner =1;
        map.put(s.charAt(cur_start), cur_start);

        while (runner<s.length() && cur_start<runner){
            char cur = s.charAt(runner);
            if (map.containsKey(cur)){
                max = Math.max(max, runner-cur_start);
                cur_start= map.get(cur)+1;
                runner = cur_start+1;
                map.clear();
                map.put(s.charAt(cur_start), cur_start);
            } else {
                map.put(s.charAt(runner), runner);
                runner++;
            }       
        }
        if (runner == s.length()){
            max = Math.max(max, runner-cur_start);
        }
        return max;
    }
}
