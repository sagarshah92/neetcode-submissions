class Solution {
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strings){
            
            StringBuilder sb = new StringBuilder();
            for(int i =0; i<str.length(); i++){
                if(i ==0){
                    sb.append(0+"|");
                    continue;
                }

                int diff = str.charAt(i)-str.charAt(i-1);
                diff = (diff<0)?diff+26:diff;
                sb.append(diff+"|");
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                map.get(key).add(str);
            } else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        //System.out.println(map);
        List<List<String>> output = new ArrayList<>();
        for(String key: map.keySet()){
            output.add(map.get(key));
        }
        return output;
        
    }
}
