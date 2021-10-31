class Solution {
  public int leastInterval(char[] tasks, int n) {
    if(tasks.length == 0) {
      return 0;
    }
      
    HashMap<Character,Integer> map = new HashMap<>();

    for(char t : tasks) {
      map.put(t, map.getOrDefault(t, 0) + 1);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.addAll(map.values());

    int maxFreq = maxHeap.poll() - 1;
    int idle = maxFreq * n;

    while(!maxHeap.isEmpty()) {
      idle -= Math.min(maxHeap.poll(), maxFreq);
    }

    return idle > 0 ? idle + tasks.length : tasks.length;
  }
}