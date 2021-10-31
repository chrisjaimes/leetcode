class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

    for (int n : map.keySet()) {
      maxHeap.add(n);
    }

    int[] res = new int[k];
    int size = maxHeap.size();
    for (int i = 0; i < k; i++) {
      res[i] = maxHeap.poll();
    }

    return res;
  }
}