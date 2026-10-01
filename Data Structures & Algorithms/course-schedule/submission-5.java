class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length<1){
            return true;
        }
        for(int i =0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] prerequisite: prerequisites){
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        System.out.println(map);
    
        for(int i =0; i<numCourses; i++){
           
           if(!dfs(i)){
            return false;
           }

            // Stack<Integer> stack = new Stack<>();
            // stack.push(i);
            // Set<Integer> visited = new HashSet<>();
            

            // while(!stack.isEmpty()){
            // int top = stack.pop();
            // visited.add(top);
            // for(int prereq: map.get(top)){
            //     if(visited.contains(prereq)){
            //         System.out.println("Break:"+visited);
            //         return false;
            //     }
            //     stack.push(prereq);
            //     //visited.add(prereq);
            //     //count++;
            //     }
            // }
            // System.out.println(visited);
            //overallvisited.addAll(visited);
           
        }
        
        return true;
    }

    public boolean dfs(int curnode){
        if(visited.contains(curnode)){
            return false;
        }

        if(map.get(curnode).isEmpty()){
            return true;
        }
        visited.add(curnode);
        for(int prereq : map.get(curnode)){
            if(!dfs(prereq)){
                return false;
            }
        }
        visited.remove(curnode);
        map.put(curnode, new ArrayList<>());
        return true;

    }
}
