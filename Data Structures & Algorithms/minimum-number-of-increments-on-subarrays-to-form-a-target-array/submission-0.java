class Solution {
    public int minNumberOperations(int[] target) {
        int[] initial = new int[target.length];
        int ans = dfs(target, 0, target.length-1, 0);
        return ans;
    }

    public int dfs(int[] target, int l , int r, int prevmin){
        if(l>r){
            return 0;
        }
        if(l==r){
            return target[l]-prevmin;
        }

        // System.out.println(Arrays.toString(initial));
        // // else fine minimum between l and r
        // int min = Integer.MAX_VALUE;
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // for(int i =l; i<=r; i++){
        //    if(target[i]<min){
        //     min = target[i];
        //     map.putIfAbsent(target[i], new ArrayList<>());
        //     map.get(target[i]).add(i);
        //    }
        // }

        // int ans = min-initial[map.get(min).get(0)];
        // int prevl =l;
        // for(int index : map.get(min)){
        //     System.out.println("Call");
        //     initial[index]=min;
        //     ans = ans+dfs(target, initial, prevl, index-1)+dfs(target, initial, index+1, );
        //     prevl = index+1;
        // }
        // System.out.println("Ans: "+ans);
        // return ans;

        //return 0;

        // find min
        int min = target[l];
        int index = l;
        for(int i =l+1; i<=r; i++){
           if(target[i]<min){
            min = target[i];
            index = i;
           }
        }
        int ans = min-prevmin;
        ans += dfs(target, l, index-1, min);
        ans +=dfs(target, index+1, r, min);

        return ans;
    }
}