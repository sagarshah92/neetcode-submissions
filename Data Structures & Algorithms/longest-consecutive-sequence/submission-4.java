class Solution {
    public int longestConsecutive(int[] nums) {
        
       Map<Integer, Integer> map = new HashMap<>();
       int max =0;
        for (int i =0; i<nums.length; i++){
            if (map.containsKey(nums[i]-1)){
                map.put(nums[i], map.get(nums[i]-1)+1);
                max = (map.get(nums[i])>max)?map.get(nums[i]):max;
                
            } else {
                 map.put(nums[i], 1);
                 max = (1>max)?1:max;
            }
            int cur = nums[i]+1;
            while (map.containsKey(cur)){
                map.put(cur, map.get(cur-1)+1);
                max = (map.get(cur)>max)?map.get(cur):max;
                cur++;
            }
        }

     //System.out.println(map);
       return max;
    }
}
