class Solution {
    public int numIslands(char[][] grid) {
        
        boolean[][]visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int r =0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if (visited[r][c]){
                    continue;
                }
                if (grid[r][c]=='0'){
                    visited[r][c]= true;
                    continue;
                }
                // found land
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{r,c});
                visited[r][c]= true;
                count++;
                while(!queue.isEmpty()){
                    int[] land = queue.poll();
                    //System.out.println("Land: "+land[0]+" "+land[1]);
                    //left 
                    int rl = land[0];
                    int cl = land[1]-1;
                    if (cl>=0 && !visited[rl][cl]){
                        if(grid[rl][cl]=='1'){
                            queue.add(new int[]{rl,cl});
                        }
                        visited[rl][cl]=true;
                    }

                    // right
                    int rr = land[0];
                    int cr = land[1]+1;
                    if (cr<grid[0].length && !visited[rr][cr]){ 
                        if(grid[rr][cr]=='1'){
                            queue.add(new int[]{rr,cr});
                        }
                        visited[rr][cr] = true;
                    }

                    // top
                    int rt = land[0]-1;
                    int ct = land[1];
                    if (rt>=0 && !visited[rt][ct]) {
                        if(grid[rt][ct]=='1'){
                        queue.add(new int[]{rt,ct});  
                        }
                        visited[rt][ct] = true;
                    }
                    // bottom
                    int rb = land[0]+1;
                    int cb = land[1];
                    if (rb<grid.length && !visited[rb][cb])  {
                        if(grid[rb][cb]=='1'){
                            queue.add(new int[]{rb,cb});
                        }
                        visited[rb][cb]=true;
                    }
                }
            }   
        }
        return count;
    }
}
