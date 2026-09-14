class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        for (int i = triangle.size()-2; i>=0; i--){
            List<Integer> currentList = triangle.get(i);
            for (int j =0; j<currentList.size(); j++){
                Integer cur = currentList.get(j);
                int min = cur + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                //System.out.println(min);
                triangle.get(i).set(j, min);
            }
        }

        return triangle.get(0).get(0);
    }
}