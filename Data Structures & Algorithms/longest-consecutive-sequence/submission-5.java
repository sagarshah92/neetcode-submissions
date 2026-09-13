class Solution {
    public int longestConsecutive(int[] nums) {
        
       Map<Integer, Integer> map = new HashMap<>();
       int max =0;
        for (int i =0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i]-1, 0)+1);
            if(map.get(nums[i])>max){
                max = map.get(nums[i]);
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
