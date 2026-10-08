class Solution {
    Map<String, Integer> map;
    int max =0;
    public int longestPalindromeSubseq(String s) {
        map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            int odd = dfs(s, i, i);
            int even = dfs(s, i, i+1);

            max = Math.max(max, Math.max(odd, even));
        }

        return max;

    }

    public int dfs (String s, int left, int right){
        if(left<0 || right>=s.length()){
            return 0;
        }
        String key = left+"-"+right;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int val =0;
        if(s.charAt(left)==s.charAt(right)){
           
            if(left==right){
                val = 1+dfs(s, left-1, right+1);
            } else {
                val = 2+dfs(s, left-1, right+1);
            }
        } else {
            val = Math.max(dfs(s, left-1, right), dfs(s, left, right+1)); 
        }
        map.put(key, val);

        return map.get(key);
    }
}