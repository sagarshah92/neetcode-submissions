class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] max = new int[nums.length-k+1];

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(
            (a,b)->Integer.compare(b, a)
        );
        int initialEnd = Math.min(k, nums.length);
        for(int i =0; i<initialEnd; i++){
            maxheap.add(nums[i]);
        }

    int left = 0;
    int right = initialEnd-1;
    while(right<nums.length){
        max[left] = maxheap.peek().intValue();
        maxheap.remove(nums[left]);
        left++;
        right++;
        if(right<nums.length){
            maxheap.add(nums[right]);
        }
        
    }

        return max;
    }
}
