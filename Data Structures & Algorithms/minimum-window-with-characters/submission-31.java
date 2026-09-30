class Solution {
    public String minWindow(String s, String t) {
        if (t.length()>s.length()){
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
        long size = Integer.MAX_VALUE;
        
        Map<Character, Integer> smap = new HashMap<>();
        Set<Character> set = new HashSet<>();

        int r=0;
        while (l<s.length()){
            char lr = s.charAt(l);
            while (l<s.length() && !map.containsKey(s.charAt(l))){
              if(smap.containsKey(s.charAt(l))){
                smap.put(s.charAt(l), smap.get(s.charAt(l))-1);
              }
             l++;
            }
            if(l==s.length()){
                break;
            }
            //System.out.println("smap:"+smap);
            if(l>r){
                r =l;
            } 
            // System.out.println("Current l:"+l);
            // System.out.println("Current r:"+r);
            // System.out.println("Starting Match :"+set.size());
            while(r<s.length() && set.size()!=map.size()){
                smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r),0)+1);

                if (map.containsKey(s.charAt(r)) && smap.get(s.charAt(r)).intValue()==map.get(s.charAt(r)).intValue()){
                    set.add(s.charAt(r));
                    //System.out.println("Match: "+match);
                }
                
                r++;

            }
            if (set.size() == map.size()){
                    //System.out.println("Call oputside if: "+match);
                    if ((r-l)<=size){
                        //System.out.println("Call: "+match);
                        index[0]= l;
                        index[1] = r;
                        size =r-l;
                        //answer = s.substring(l, r);
                        //System.out.println(answer);
                        //return answer;
                    }
                    //break;
            }
            // System.out.println("Ending L:"+l);
            // System.out.println("Ending R:"+r);
            // System.out.println("Ending match:"+set.size());
            smap.put(s.charAt(l), smap.get(s.charAt(l))-1);
            if(smap.get(s.charAt(l))<map.get(s.charAt(l))){
                set.remove(s.charAt(l));
            }
            //match--;
            l++;
                   
        }
        //System.out.println(size);
        //System.out.println(Arrays.toString(index));
        return (index[0]!=-1 && index[1]!=-1)?s.substring(index[0],index[1]):"";

    }
}
