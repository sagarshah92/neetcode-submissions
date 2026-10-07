class Solution {
    int targetSum = 0;
    boolean[] visited; 
    int counter =0;
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum =0;
        for (int num: nums){
            sum+=num;
        }

        //System.out.println("Sum: "+sum);
        if(sum%k!=0){
            return false;
        }
        targetSum = sum/k;
        //System.out.println("Target Sum: "+targetSum);
        visited = new boolean[nums.length];
        return backtrack(nums, k, 0, 0);
    }

    public boolean backtrack(int[] nums, int k, int index, int currentSum){
        counter = counter+1;
        //System.out.println("Counter: "+counter);
        if(k == 0){
            return true;
        }
        if(currentSum == targetSum){
            return backtrack(nums, k-1, 0, 0);
        }

        for(int i = index; i<nums.length; i++){
            if(visited[i] || currentSum+nums[i]>targetSum){
                continue;
            }

            visited[i]= true;
            boolean isPartition = backtrack(nums, k, i+1, currentSum+nums[i]);
            if(isPartition){
                return true;
            }
            visited[i]= false;

        }
        return false;
    }
}