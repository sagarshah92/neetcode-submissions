class Distance{
    int index;
    double distance;

    public Distance(int index, double distance){
        this.index = index;
        this.distance = distance;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //PriorityQueue<Distance> minheap = new PriorityQueue<>();
        PriorityQueue<Distance> minheap = new PriorityQueue<>(
            (p1, p2) -> Double.compare(p1.distance, p2.distance)
        );

        for (int i =0; i<points.length;i++ ){
            
            double distance = Math.sqrt((points[i][0]*points[i][0]) + (points[i][1]*points[i][1]));
            System.out.println("Distance: "+distance+ " X: "+points[i][0]+ " Y:"+points[i][1]);
            minheap.add(new Distance(i, distance));
           
        }

        int[][] output = new int[k][2];
        for (int i=0; i<k; i++){
            output[i]= points[minheap.poll().index];
        }
        return output;

    }
}
