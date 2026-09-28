class MinStack {
    Stack<Integer> minstack;
    Stack<Integer> stack;

    public MinStack() {
        this.minstack = new Stack<>();
        this.stack= new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty()){
            minstack.push(val);
        } else{
            if(val<=minstack.peek()){
                minstack.push(val);
            }
            //minstack.push(Math.min(minstack.peek(), val));
        }
        
    }
    
    public void pop() {
        int top = stack.pop();
        if(minstack.peek()==top){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
