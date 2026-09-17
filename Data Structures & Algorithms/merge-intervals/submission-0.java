
class Solution {
    public int[][] merge(int[][] intervals) {

        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            (p1,p2)->Integer.compare(p1[0],p2[0])
        );

        for (int[] interval: intervals){
            minheap.add(interval);
        }

        List<int[]> output = new ArrayList<>();
        
        while(!minheap.isEmpty()){
            int[] top = minheap.remove();
            // System.out.println(top);
            if (output.size()==0){
                output.add(top);
                continue;
            }

            //int[] last = output.get(output.size()-1);

            if(top[0]>output.get(output.size()-1)[1]){
                output.add(top);
            } else{
                output.get(output.size()-1)[0]= Math.min(top[0], output.get(output.size()-1)[0]);
                output.get(output.size()-1)[1]= Math.max(top[1], output.get(output.size()-1)[1]);
                //output.add(output.size()-1, last);
            }
        }

        int[][] finaloutput = new int[output.size()][2];
        int index =0;
        for (int[] element: output){
            finaloutput[index++]=element;
        }
        return finaloutput;
    }
}
