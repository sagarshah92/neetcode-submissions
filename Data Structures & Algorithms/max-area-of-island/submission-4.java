class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        //Set<String> set = new HashSet<>();
        int rows = grid.length;
        int cols =  grid[0].length;
        boolean[][] set = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j =0; j<cols; j++){
                // already visited
                if(set[i][j]){
                    continue;
                }

                // non land
                if(grid[i][j]!=1){
                    set[i][j]=true;
                    continue;
                }
                // found unvisted land. 
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                set[i][j]=true;
                int count =0;
                while(!queue.isEmpty()){
                    int[] front = queue.poll();
                    count++;
                    //System.out.println(front[0]+"-"+front[1]);
                    // left
                    int nextr = front[0];
                    int nextc = front[1]-1;
                    if(nextc>=0 && !set[nextr][nextc]){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});    
                        } 
                        set[nextr][nextc]=true;
                    }

                    // right
                    nextr = front[0];
                    nextc = front[1]+1;
                    if(nextc<cols && !set[nextr][nextc]){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});   
                        } 
                        set[nextr][nextc]=true;
                    }

                    // top
                    nextr = front[0]-1;
                    nextc = front[1];
                    if(nextr>=0 && !set[nextr][nextc]){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});
                        } 
                        set[nextr][nextc]=true;
                        
                    }

                    // bottom
                    nextr = front[0]+1;
                    nextc = front[1];
                    if(nextr<rows&& !set[nextr][nextc]){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});        
                        } 
                        set[nextr][nextc]=true;
                        
                    }
                }
                max = Math.max(max, count);
                //System.out.println("Max: "+max);
            }
        }
        return max;
        
    }
}
