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
            minstack.push(Math.min(minstack.peek(), val));
        }
        
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
