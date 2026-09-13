class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
		for (int num: nums){
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		// // 1-1
		// // 2-2
		// // 3-3
		// List<int[]> list = new ArrayList<>();
		// map.forEach((key, val) -> {
		// 	list.add(new int[]{val, key});
		// });

		// // sorting array decending
		// list.sort((a,b)->b[0]-a[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
		map.forEach((key, val) ->{
			pq.add(new int[]{val, key});
		} );

		// System.out.println(pq);
		int[] answer = new int[k];
		for (int i =0 ;i<k; i++){
			answer[i] = pq.poll()[1];
		}
		

		return answer;
    }
}
