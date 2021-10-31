class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

    for (int n : map.keySet()) {
      minHeap.add(n);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    int[] res = new int[k];
    int size = minHeap.size();
    for (int i = 0; i < size; i++) {
      res[i] = minHeap.poll();
    }

    return res;
  }
}