class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    for (int s : stones) {
      maxHeap.add(s);
    }
      
    while (maxHeap.size() > 1) {
      int stoneOne = maxHeap.remove();
      int stoneTwo = maxHeap.remove();
      
      if (stoneOne != stoneTwo) {
        maxHeap.add(stoneOne - stoneTwo);
      }
    }
      
    return (maxHeap.size() == 0) ? 0 : maxHeap.remove();
  }
}