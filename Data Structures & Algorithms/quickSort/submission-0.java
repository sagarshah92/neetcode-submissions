// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs, 0, pairs.size()-1);
        return pairs;
    }

    public void quickSortHelper(List<Pair> pairs, int start, int end){

        if(end-start+1<=1){
            return;
        }
        Pair pivot = pairs.get(end);
        int left = start;

        for(int i =start; i<end; i++){
            if(pairs.get(i).key<pivot.key){
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
        }
        pairs.set(end, pairs.get(left));
        pairs.set(left,pivot);
        
        quickSortHelper(pairs, start, left-1);
        quickSortHelper(pairs, left+1, end);
    }
}
