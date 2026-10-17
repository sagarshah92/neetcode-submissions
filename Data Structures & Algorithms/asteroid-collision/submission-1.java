class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        if(asteroids.length<2){
            return asteroids;
        }
        int l =0;
        int r =1;

        while(r<asteroids.length){
           if(asteroids[l]>0 && asteroids[r]<0){
            int firstVal = Math.abs(asteroids[l]);
            int secondval = Math.abs(asteroids[r]);
            
            if(firstVal>secondval){
                asteroids[r]=0;
                r++;
            } else if(secondval>firstVal){
                asteroids[l]=0;
                l--;
                while(l>=0 && asteroids[l]==0){
                    l--;
                }
                if(l<0){
                    l=r;
                    r++;
                }
            } else{
                asteroids[l]=0;
                asteroids[r]=0;
                r++;
                l--;
                while(l>=0 && asteroids[l]==0){
                    l--;
                }
                if(l<0){
                    l=r;
                    r++;
                }
            }
           } else{
            l++;
            while(asteroids[l]==0){
                l++;
            }
            r++;
           }
        }
        List<Integer> list = new ArrayList<>();
        for(int i : asteroids){
            if(i!=0){
                list.add(i);
            }
        }

        int[] output = new int[list.size()];
        int index =0;
        for(int val : list){
            output[index]=val;
            index++;
        }
        return output;
    }
}