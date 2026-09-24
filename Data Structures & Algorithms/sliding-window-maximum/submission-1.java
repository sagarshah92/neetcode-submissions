class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    //     int[] max = new int[nums.length-k+1];

    //     PriorityQueue<Integer> maxheap = new PriorityQueue<>(
    //         (a,b)->Integer.compare(b, a)
    //     );
    //     int initialEnd = Math.min(k, nums.length);
    //     for(int i =0; i<initialEnd; i++){
    //         maxheap.add(nums[i]);
    //     }

    // int left = 0;
    // int right = initialEnd-1;
    // while(right<nums.length){
    //     max[left] = maxheap.peek().intValue();
    //     maxheap.remove(nums[left]);
    //     left++;
    //     right++;
    //     if(right<nums.length){
    //         maxheap.add(nums[right]);
    //     }
        
    // }

    //     return max;
    // }

    int length = nums.length;
    int[] output = new int[length-k+1];

    int l =0;
    int r =0;
    Deque<Integer> dequeue = new LinkedList<>();
    while(r<length){
        //System.out.println(dequeue);
        while(!dequeue.isEmpty() && dequeue.getLast().intValue()<nums[r]){
            //System.out.println(dequeue.getLast().intValue());
            dequeue.removeLast();
        }
        Integer last = nums[r];
        //System.out.println(nums[r]);
        dequeue.addLast(last);
        if(r-l+1>k){
            if (dequeue.getFirst().intValue()==nums[l]){
                dequeue.removeFirst();
            }
            l++;
        }
        if(r+1>=k){
            output[r+1-k]= dequeue.getFirst().intValue();
        }
        r++;
    }

    return output;
    }
}
