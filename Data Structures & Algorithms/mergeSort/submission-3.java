// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size()-1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int start, int end){

        if(end-start+1<=1){
            return pairs;
        }

        int mid = start+(end-start)/2;
        mergeSortHelper(pairs, start, mid);
        mergeSortHelper(pairs, mid+1, end);
        merge(pairs, start, mid, end);
        return pairs;
    }

    public void merge(List<Pair> pairs, int start, int mid, int end){
        List<Pair> leftlist = new ArrayList<>(pairs.subList(start, mid+1));
        List<Pair> rightList = new ArrayList<>(pairs.subList(mid+1, end+1));


        int i =0;
        int j =0;
        int k =start;

        while(i<leftlist.size() && j<rightList.size()){
            if(leftlist.get(i).key<=rightList.get(j).key){
                pairs.set(k, leftlist.get(i));
                i++;
            } else{
                pairs.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        while(i<leftlist.size()){
            pairs.set(k, leftlist.get(i));
            i++;      
            k++;
        }
        while(j<rightList.size()){
            pairs.set(k, rightList.get(j));
            j++;      
            k++;
        }

        // for(Pair p : pairs){
        //     System.out.print(p.key+" ");
        // }
        // System.out.println();
    }
}
