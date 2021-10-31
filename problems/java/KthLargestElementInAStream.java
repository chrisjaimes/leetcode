class KthLargest {
  int capacity;
  PriorityQueue<Integer> minHeap;

  public KthLargest(int k, int[] nums) {
    this.capacity = k;
    this.minHeap = new PriorityQueue<>();
    for (int n : nums) {
      this.add(n);
    }
  }
  
  public int add(int val) {
    minHeap.add(val);
  
    if (minHeap.size() > this.capacity) {
      minHeap.remove();
    }
    
    return minHeap.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */