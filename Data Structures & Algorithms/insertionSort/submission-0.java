// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> output = new ArrayList<>();

        int size = pairs.size();

        for(int i =0; i<size; i++){

            int j = i-1;
            //List<Pair> currentList = new ArrayList<>(pairs);

            while(j>=0 && pairs.get(j).key>pairs.get(j+1).key){
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, temp);
                j--;
            }

            List<Pair> intermdeidate = new ArrayList<>(pairs);
            output.add(intermdeidate);
        }
        return output;
    }
    
}
