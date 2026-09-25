class Solution {
    public String removeDuplicates(String s, int k) {
        if(s.length()<k){
            return s;
        }
        
        Stack<Tupple> stack= new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek().c == s.charAt(i)){
                stack.peek().count++;
                //System.out.println("Stack updating: "+ stack.peek().c+" count:"+stack.peek().count);
                if(stack.peek().count==k){
                    stack.pop();
                }
                
            } else{
                stack.push(new Tupple(s.charAt(i)));
                //System.out.println("Entering new: "+ s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Tupple top = stack.pop();
            for(int i=0;i<top.count; i++){
                sb.append(top.c);
            }
        }
        
        return sb.reverse().toString();
    }
}

class Tupple{
    char c;
    int count; 

    public Tupple(char c){
        this.c= c;
        this.count=1;
    }
}