class Solution {
    public boolean isValid(String s) {
        
        // Stack
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            } else if (s.charAt(i)==')'){
                if (stack.isEmpty() || stack.peekFirst()!='('){
                    return false;
                }
                stack.pop();
            } else if (s.charAt(i)=='}'){
                if (stack.isEmpty() || stack.peekFirst()!='{'){
                    return false;
                }
                stack.pop();
            } else if (s.charAt(i)==']'){
                if (stack.isEmpty() || stack.peekFirst()!='['){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.size()==0;
    }
}
