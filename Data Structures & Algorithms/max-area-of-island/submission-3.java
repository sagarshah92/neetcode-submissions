class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        Set<String> set = new HashSet<>();
        int rows = grid.length;
        int cols =  grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j =0; j<cols; j++){
                // already visited
                if(set.contains(i+"-"+j)){
                    continue;
                }

                // non land
                if(grid[i][j]!=1){
                    set.add(i+"-"+j);
                    continue;
                }
                // found unvisted land. 
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                set.add(i+"-"+j);
                int count =0;
                while(!queue.isEmpty()){
                    int[] front = queue.poll();
                    count++;
                    //System.out.println(front[0]+"-"+front[1]);
                    // left
                    int nextr = front[0];
                    int nextc = front[1]-1;
                    if(nextc>=0 && !set.contains(nextr+"-"+nextc)){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});    
                        } 
                        set.add(nextr+"-"+nextc);
                    }

                    // right
                    nextr = front[0];
                    nextc = front[1]+1;
                    if(nextc<cols && !set.contains(nextr+"-"+nextc)){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});   
                        } 
                        set.add(nextr+"-"+nextc);
                    }

                    // top
                    nextr = front[0]-1;
                    nextc = front[1];
                    if(nextr>=0 && !set.contains(nextr+"-"+nextc)){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});
                        } 
                        set.add(nextr+"-"+nextc);
                        
                    }

                    // bottom
                    nextr = front[0]+1;
                    nextc = front[1];
                    if(nextr<rows&& !set.contains(nextr+"-"+nextc)){
                        if(grid[nextr][nextc]==1){
                            queue.add(new int[]{nextr,nextc});        
                        } 
                        set.add(nextr+"-"+nextc);
                        
                    }
                }
                max = Math.max(max, count);
                //System.out.println("Max: "+max);
            }
        }
        return max;
        
    }
}
