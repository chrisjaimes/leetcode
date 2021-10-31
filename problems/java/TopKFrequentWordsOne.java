class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String w : words) {
      map.put(w, map.getOrDefault(w, 0) + 1);
    }
    
    PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> (!map.get(a).equals(map.get(b))) ? map.get(b) - map.get(a) : a.compareTo(b));
    
    for (String s : map.keySet()) {
      minHeap.add(s);
    }
    
    List<String> result = new ArrayList<>();
    while (!minHeap.isEmpty() && k-- > 0) {
      result.add(minHeap.remove());
    }
    
    return result;
  }
}