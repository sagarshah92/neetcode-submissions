/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int r =0;
        int c =0;
        int peopleToCeleb =0;
        //int celebToPeople =0;
        while(c<n){
            //System.out.println("start r: "+r+" start c: "+c);

            if(!knows(r,c)){
                c++;
                if(c==n){
                    break;
                }
                continue;
            }
            while(r<n && knows(r,c)){
                //System.out.println("call "+r);
                if(knows(c,r) && c!=r){
                    //System.out.println("Inside celebToPeople"+r);
                    break;
                }
                r++;
            }
            //System.out.println("celebToPeople"+celebToPeople);
            if(r==n){ 
                return c;
            } else{
                r=0;
                c++;
                //celebToPeople=0;
            }

            //System.out.println("end r: "+r+" end c: "+c);
        }
        return -1;

    }
    }

