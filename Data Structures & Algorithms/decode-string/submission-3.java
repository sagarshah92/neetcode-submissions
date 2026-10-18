class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            // if( c=='[' || (c>='a' && c<='z')){
            //     stack.push(c+""); 
            // } else if(Character.isDigit(c)){
            //     if(!stack.isEmpty() && isNumber(stack.peek())){
            //         int peek = Integer.parseInt(stack.pop());
            //         int num = (peek*10)+Integer.parseInt(c+"");
            //         stack.push(num+"");
            //     } else{
            //         stack.push(c+"");
            //     }
            // } else{
            //     //first closing brack found
            //     String str="";
            //     while(!stack.peek().equals("[")){
            //         str = stack.pop()+str;
            //     }
            //     // opening bracket;
            //     stack.pop();
            //     if(!stack.isEmpty() && isNumber(stack.peek())){
            //         String top = stack.peek();
            //         int num = Integer.parseInt(top);
            //         StringBuilder dsb = new StringBuilder();
            //         for(int k=0; k<num;k++){
            //             dsb.append(str);
            //         }
            //         stack.pop();//pop number
            //         stack.push(dsb.toString());
            //     } else {
            //         stack.push(str);
            //     }
            // }

            if(c!=']'){
                stack.push(c+"");
            } else {
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")){
                    sb.insert(0, stack.pop());
                }

                stack.pop();// opening bracket
                StringBuilder k = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    k.insert(0, stack.pop());
                }
                int num = Integer.parseInt(k.toString());
                String repeatedStr = sb.toString().repeat(num);
                stack.push(repeatedStr);

            }
        }
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()){
            output.insert(0, stack.pop());
        }
        return output.toString();
    }

    // public boolean isNumber(String top){
    //     for(int i =0; i<top.length(); i++){
    //         if(!Character.isDigit(top.charAt(i))){
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}