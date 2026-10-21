class Solution {
    public int maximumSwap(int num) {

        List<Integer> list = new ArrayList<>();
        int tempnum= num;
        while(tempnum>0){
            int rem = tempnum%10;
            list.add(0, rem);
            tempnum = tempnum/10;
        }

        System.out.println(list);
        if(list.size()<2){
            return num;
        }

        int[][] rightmax = new int[list.size()][2];
        rightmax[list.size()-1][0] = list.get(list.size()-1);
        rightmax[list.size()-1][1] = list.size()-1;
        
        for(int i =list.size()-2; i>=0; i--){
            if(list.get(i)>rightmax[i+1][0]){
                rightmax[i][0] = list.get(i);
                rightmax[i][1] = i;
            } else {
                rightmax[i][0] = rightmax[i+1][0];
                rightmax[i][1] = rightmax[i+1][1];
            }
        }
        System.out.println(Arrays.deepToString(rightmax));
        boolean swap = false;
        int ans = 0;
        for(int i =0; i<list.size(); i++){

            if(!swap && list.get(i)<rightmax[i][0]){
                int index = rightmax[i][1];
                int temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
                swap = true;
            }
            ans = (ans*10)+list.get(i);
        }
        System.out.println(list);
        System.out.println(ans);
        return ans;
    }
}
