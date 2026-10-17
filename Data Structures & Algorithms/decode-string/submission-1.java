class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if( c=='[' || (c>='a' && c<='z')){
                stack.push(c+""); 
            } else if(Character.isDigit(c)){
                if(!stack.isEmpty() && isNumber(stack.peek())){
                    int peek = Integer.parseInt(stack.pop());
                    int num = (peek*10)+Integer.parseInt(c+"");
                    stack.push(num+"");
                } else{
                    stack.push(c+"");
                }
            } else{
                //first closing brack found
                //StringBuilder sb = new StringBuilder();
                String str="";
                while(!stack.peek().equals("[")){
                    str = stack.pop()+str;
                    //sb.append();
                }
                System.out.println(str);
                // opening bracket;
                stack.pop();
                if(!stack.isEmpty() && isNumber(stack.peek())){
                    String top = stack.peek();
                    int num = Integer.parseInt(top);
                    StringBuilder dsb = new StringBuilder();
                    for(int k=0; k<num;k++){
                        dsb.append(str);
                    }
                    stack.pop();//pop number
                    stack.push(dsb.toString());
                } else {
                    stack.push(str);
                }
                //System.out.println(sb.toString());
                //break;
            }
            System.out.println(stack);
        }
        //System.out.println(stack);
        String output = "";
        while(!stack.isEmpty()){
            output = stack.pop()+output;
        }

        //System.out.println(output);

        return output;
    }

    public boolean isNumber(String top){
        for(int i =0; i<top.length(); i++){
            if(!Character.isDigit(top.charAt(i))){
                return false;
            }
        }

        return true;
    }
}