class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];

        Stack<Pair> stack = new Stack<>();
        for(int i =0; i<temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i]>stack.peek().val){
                Pair top = stack.pop();
                output[top.index]= i-top.index;
            }
            stack.push(new Pair(i, temperatures[i]));

        }

        while(!stack.isEmpty()){
            Pair top = stack.pop();
            output[top.index]= 0;
        }
        
        return output;
    }
}

class Pair {
    int index;
    int val;

    public Pair(int index, int val){
        this.index = index;
        this.val = val;
    }
}
