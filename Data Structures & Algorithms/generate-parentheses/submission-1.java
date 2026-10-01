class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        if(n==0){
            return output;
        }
        for(int i =0; i<n; i++){
            Set<String> set = new HashSet<>();
            int size = output.size();
            if(i==0){
                output.add("()");
                continue;
            }
            for(String str: output){
                System.out.println(str);
                for (int j =0; j<str.length(); j++){
                    if(str.charAt(j)=='('){
                        System.out.println("Called");
                        set.add(str.substring(0,j+1)+"()"+str.substring(j+1));
                    }
                }
                set.add("()"+str);
                set.add(str+"()");
                //System.out.println(set);

            }
            output.clear();
            output.addAll(set);
        }

        System.out.println(output);

        return output;
    }
}
