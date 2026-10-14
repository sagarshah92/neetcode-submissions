class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");

        int num =0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<s.length();i++){
            char cur = s.charAt(i);
            //System.out.println(cur);
            if(Character.isDigit(cur)){
                num = (num*10)+Integer.parseInt(cur+"");
            }

            if(!Character.isDigit(cur) || i == s.length()-1){
                //System.out.println("Called secopnd if "+op);
                if(op == '+'){
                    //System.out.println("Called plus");
                    stack.push(num);
                } else if(op=='-'){
                    stack.push(-num);
                } else if(op=='*'){
                    //System.out.println("Called");
                    int prev = stack.pop();
                    stack.push(prev*num);
                } else {
                    int prev = stack.pop();
                    stack.push(prev/num);
                }
                num =0;
                op = s.charAt(i);
            }
            
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans = ans+stack.pop();
        }

        return ans;
    }
}