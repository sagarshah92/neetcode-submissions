class MinStack {
    Deque<Integer> minstack;
    Deque<Integer> stack;

    public MinStack() {
        this.minstack = new ArrayDeque<>();
        this.stack= new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty()){
            minstack.push(val);
        } else{
            minstack.push(Math.min(minstack.peekFirst(), val));
        }
        
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minstack.peekFirst();
    }
}
