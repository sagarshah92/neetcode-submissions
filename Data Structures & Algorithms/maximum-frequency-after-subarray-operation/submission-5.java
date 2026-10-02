class Solution {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i =0; i<nums.length; i++){
            int preval = Math.max(map.getOrDefault(nums[i], 0), map.getOrDefault(k, 0));
            map.put(nums[i], preval+1);
            max = Math.max(max, map.get(nums[i])-map.getOrDefault(k, 0));
        }
        System.out.println("Max: "+max);
        return max+map.getOrDefault(k, 0);
    }
}