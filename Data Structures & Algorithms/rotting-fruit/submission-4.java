class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][]visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        int freshcount=0;
        int answer =0;

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    freshcount++;
                } else if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                    visited[i][j]= true;
                } else {
                    visited[i][j]= true;
                }
            }
        }
        // //System.out.println(queue.size());
        if (freshcount==0){
            return answer;
        }

        while(!queue.isEmpty()){
            answer++;
            int size = queue.size();
            //System.out.println("Begining:"+ size);

            for(int i =0; i<size; i++){
                int[] top = queue.remove();
                //System.out.println("X:"+ top[0]+ " y:"+top[1]);
                // left
                int lr = top[0];
                int lc = top[1]-1;
                if(lc>=0 && visited[lr][lc]==false && grid[lr][lc]==1){
                    queue.add(new int[]{lr,lc});
                    visited[lr][lc]= true;
                    freshcount--;
                }

                // right
                lr = top[0];
                lc = top[1]+1;
                if(lc<cols && visited[lr][lc]==false && grid[lr][lc]==1){
                    queue.add(new int[]{lr,lc});
                    visited[lr][lc]= true;
                    freshcount--;
                }

                // top
                lr = top[0]-1;
                lc = top[1];
                if(lr>=0 && visited[lr][lc]==false && grid[lr][lc]==1){
                    queue.add(new int[]{lr,lc});
                    visited[lr][lc]= true;
                    freshcount--;
                }

                // bottom
                lr = top[0]+1;
                lc = top[1];
                if(lr<rows && visited[lr][lc]==false && grid[lr][lc]==1){
                    queue.add(new int[]{lr,lc});
                    visited[lr][lc]= true;
                    freshcount--;
                }
            }
            //System.out.println("At the end:"+ queue.size());
            
            // if(answer==2){
            //     break;
            // }
            //break;
        }
        
        return (freshcount==0)?answer-1:-1;

        
    }
}
