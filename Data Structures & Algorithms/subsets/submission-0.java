class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length<0){
            return null;
        }
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums){
            int size = output.size();
            for(int i = 0 ; i<size ; i++){
                List<Integer> sublist = new ArrayList<>(output.get(i));
                sublist.add(num);
                output.add(sublist);
                //System.out.println(output);
            }
        }
        //System.out.println(output);
        return output;
        
        
    }
}
