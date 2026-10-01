class Solution {
    public int evalRPN(String[] tokens) {
        //int answer = 0;
        if(tokens.length==0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")||token.equals("*")||token.equals("-")||token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int answer =0;
                if(token.equals("+")){
                    answer = a+b;
                } else if(token.equals("-")){
                    answer = a-b;
                } else if (token.equals("*")){
                     answer = a*b;
                } else{
                    answer = a/b;
                }
                stack.push(answer);
            } else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
