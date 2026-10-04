class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] cars = new int[position.length][2];
        PriorityQueue<double[]> queue = new PriorityQueue<>(
            (a,b)->Double.compare(b[0], a[0])
        );

        for(int i =0; i<position.length; i++){
            double timeToTarget = (double)(target-position[i])/speed[i];
            //System.out.println("timeToTarget: "+timeToTarget);
            queue.add(new double[]{position[i], speed[i], timeToTarget});
        }
        int count=0;
        while(!queue.isEmpty()){
           double[] top = queue.poll();
           //System.out.println("position: "+top[0]+" speed: "+top[1]+" timeToTarget: "+top[2]);
           count++;
           while(!queue.isEmpty() && top[2]>=queue.peek()[2]){
            //System.out.println("Call");
            queue.poll();
           }
        }

        return count;
    }
}
