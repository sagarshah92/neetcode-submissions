/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        
        //int count ;
        if (intervals.size()<1){
            return 0;
        }

        
        int[] startTimes = new int[intervals.size()];
        int[] endTimes = new int[intervals.size()];

        for(int i =0; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            startTimes[i]= current.start;
            endTimes[i] = current.end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int maxCount=0;
        int count=0;

        int s =0;
        int e =0;
        while(s<startTimes.length && e <endTimes.length){
            if(startTimes[s]<endTimes[e]){
                count++;
                maxCount= Math.max(maxCount, count);
                s++;
            } else {
                count--;
                e++;
            }
        }
        return maxCount;
        // 1st iteration
        // intervals.sort((i1, i2)->Integer.compare(i1.start, i2.start));
        // PriorityQueue<Interval> pq= new PriorityQueue<>(
        //     (i1,i2) -> Integer.compare(i1.end, i2.end)
        // );

        // for (Interval i:intervals){
        //    if(pq.isEmpty()){
        //     pq.add(i);
        //     continue;
        //    }
        //    if(pq.peek().end>i.start){
        //     pq.add(i);
        //    } else{
        //     pq.remove();
        //     pq.add(i);
        //    }

        // }
        

        // return pq.size();
    }
}
