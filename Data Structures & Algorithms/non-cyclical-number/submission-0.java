class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = digitsSquareTotal(n);
        }
        return n==1;
    }

    public int digitsSquareTotal(int n){
        int total =0;
        while(n!=0){
            int reminder = n%10;
            total += (reminder*reminder);
            n = n/10;
        }
        System.out.println(total);
        return total;
    }
}
