class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    int length = nums.length;
    int[] output = new int[length-k+1];

    int l =0;
    int r =0;
    Deque<Integer> dequeue = new LinkedList<>();
    while(r<length){
        
        while(!dequeue.isEmpty() && dequeue.getLast().intValue()<nums[r]){
            dequeue.removeLast();
        }
        Integer last = nums[r];
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
