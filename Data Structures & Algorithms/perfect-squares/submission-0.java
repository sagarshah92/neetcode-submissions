class Solution {
    public int numSquares(int n) {
        int count =0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        while (!queue.isEmpty()){
            count++;

            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.remove();
                for(int j =1; j*j+cur<=n; j++){
                    int total = j*j+cur;
                    if(total==n){
                        return count;
                    }
                    if(!visited.contains(total)){
                        queue.add(total);
                        visited.add(total);
                    }
                }
            }


        }
        return count;

    }
}