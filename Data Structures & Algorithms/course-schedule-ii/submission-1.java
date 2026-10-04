class Solution {
    public List<Integer> output = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i =0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] prerequisite: prerequisites){
                map.get(prerequisite[0]).add(prerequisite[1]);
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        for(int i =0; i<numCourses; i++){
            if(!set.contains(i)){

                boolean valid = dfs(i, map, set, cycle, output);
                if(!valid){
                    return  new int[0];
                }
                //System.out.println("Sagar: "+ output);
            }  
        }

        int[] result = new int[numCourses];
        for(int i =0; i<numCourses; i++){
            result[i]= output.get(i);
        }

        return result;
    }

    public boolean dfs(
        int course, 
        Map<Integer, List<Integer>> map,
        Set<Integer> visited, 
        Set<Integer> cycle,
        List<Integer> output){
        if(cycle.contains(course)){
            return false;
        }

        if(visited.contains(course)){
            return true;
        }

        cycle.add(course);
        for(int courseP : map.get(course)){
            
            if(!dfs(courseP, map, visited, cycle, output)){
                return false;
            }
            //set.remove(course);
        }
        visited.add(course);
        output.add(course);
        cycle.remove(course);
        return true;
    }
}
