class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>  output = new ArrayList<>();

        for(int i= 0; i<nums.length; i++){
            dfs(nums, i, 0, target, new ArrayList<>(), output);
        }   
        return output;
    }
    public void dfs(int[] nums, int index, int cursum, int target, List<Integer> curlist, List<List<Integer>>  output){
        //System.out.print(curlist);
        if(index<nums.length){
            //System.out.println(nums[index]);
        }
        if(cursum == target){
            output.add(curlist);
            //System.out.println(curlist+" "+"call");
            return;
        }

        if(cursum>target || index>=nums.length){
            return;
        }
        

        int cur = nums[index];
        int count = (target-cursum)/cur;
        while(count>0){
            int totalsum =cursum;
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(curlist);
            for(int i =0; i<count; i++){
                tempList.add(cur);
                totalsum+=cur;
            }
            if(totalsum==target){
                output.add(tempList);
                
            }else if(index ==nums.length-1){
                dfs(nums, index+1, totalsum, target, tempList, output);
            } else{
                for (int i= index+1; i<nums.length; i++){
                    if(totalsum+nums[i]<=target){
                        dfs(nums, i, totalsum, target, tempList, output);
                    }
                }
            }
            count--;
        }
        //dfs(nums, index+1, 0, target, new ArrayList<>(), output);
        return ;
    }
}
