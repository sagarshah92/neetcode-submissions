class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer=0;
        int l=0;
        for(int r =0; r<fruits.length; r++){
            //System.out.println("l: "+l+" r:"+r);
            
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
            if(map.size()<=2){
                answer = Math.max(answer, r-l+1);
                //System.out.println(map);
                //continue;
            } else {
                while(l<=r){
                    map.put(fruits[l], map.get(fruits[l])-1);
                    if(map.get(fruits[l])==0){
                        map.remove(fruits[l]);
                        l++;
                        break;
                    } else{
                        l++;
                    }
                }
            }
            //System.out.println(map);
        }
        return answer;
    }
}