class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if (s1.length() > s2.length()){
        return false;
       }

     Map<Character, Integer> s1map = new HashMap<>();
     Map<Character, Integer> s2map = new HashMap<>();

     for (int i =0; i<s1.length(); i++){
        s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0)+1);
        s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0)+1);
     }

    
    int match =0;

    for(Character c: s1map.keySet()){
        if(s2map.containsKey(c) && s1map.get(c)==s2map.get(c)){
            match++;
        }
    }
    int l=0;
   for(int r= s1.length(); r<s2.length(); r++){
        // System.out.println("s1map: "+s1map);
        // System.out.println("s2map: "+s2map);
        // System.out.println("match: "+match);
        if (match == s1map.size()){
            //System.out.println("Call: "+match);
            return true;
        }
        Character c = s2.charAt(r);
        s2map.put(c, s2map.getOrDefault(c, 0)+1);
       
        if (s1map.containsKey(c) && s1map.get(c)==s2map.get(c)){
            match++;
        } else if(s1map.containsKey(c) && s1map.get(c)+1==s2map.get(c)){
            match--;
        }
        Character lc = s2.charAt(l);
        s2map.put(lc, s2map.get(lc)-1);
        if (s1map.containsKey(lc) && s1map.get(lc)-1==s2map.get(lc)){
            match--;
        } else if (s1map.containsKey(lc) && s1map.get(lc)==s2map.get(lc)){
            match++;
        }
        l++;
    }
    // System.out.println("s1map: "+s1map);
    // System.out.println("s2map: "+s2map);
    // System.out.println("match: "+match);
    return match == s1map.size();
}
}
