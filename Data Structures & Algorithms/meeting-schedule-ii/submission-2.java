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

        int prevEndTime= 0;

        intervals.sort((i1, i2)->Integer.compare(i1.start, i2.start));

        PriorityQueue<Interval> pq= new PriorityQueue<>(
            (i1,i2) -> Integer.compare(i1.end, i2.end)
        );

        for (Interval i:intervals){
           if(pq.isEmpty()){
            pq.add(i);
            continue;
           }

           if(pq.peek().end>i.start){
            pq.add(i);
           } else{
            pq.remove();
            pq.add(i);
           }

        }
        

        return pq.size();
    }
}
