class Solution {
   public String minWindow(String s, String t) {
       if (t.length()<1){
           return "";
       }
       Map<Character, Integer> map = new HashMap<>();
       for(int i =0; i<t.length(); i++){
           int currentcount = map.getOrDefault(t.charAt(i), 0);
           map.put(t.charAt(i),currentcount+1);
       }


       //System.out.println(map);


     
       int l =0;
       int[] index = new int[]{-1,-1};
       int size = Integer.MAX_VALUE;
      
       Map<Character, Integer> smap = new HashMap<>();
       int have =0;
       for (int r =0; r<s.length(); r++){
           char c = s.charAt(r);
           smap.put(c, smap.getOrDefault(c, 0)+1);
           if(map.containsKey(c) && smap.get(c).intValue() == map.get(c).intValue()){
               have++;
           }


           while (have==map.size()){
               char lc = s.charAt(l);
               // update minimum
               if(r-l+1<size){
                   index[0]=l;
                   index[1]=r;
                   size = r-l+1;
               }
               // update Map
               smap.put(lc, smap.get(lc)-1);
               if(map.containsKey(lc) && smap.get(lc) < map.get(lc)){
                   have--;
               }
               l++;
           }
       }
       //System.out.println(size);
       //System.out.println(Arrays.toString(index));
       return size==Integer.MAX_VALUE ? ""  : s.substring(index[0], index[1]+1);


   }
}