class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs){
            res.append(str.length()).append("#").append(str);
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {

      List<String> output =new ArrayList<>();
      int start_index=0;
      while (start_index<str.length()){
        int run_index = start_index;
        while (str.charAt(run_index)!='#'){
            run_index++;
        }
        System.out.println("Start_index: "+start_index);
        System.out.println("Run_index: "+ run_index);
        int length = Integer.parseInt(str.substring(start_index, run_index));
        System.out.println(length);
        output.add(str.substring(run_index+1,run_index+1+length));
        start_index = run_index+length+1;
      }

        return output;
    }
}
