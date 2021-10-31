class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (a, b) -> {
      return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
    });
    
    for (int i = 0; i < points.length; i++) {
      minHeap.add(points[i]);
    }
    
    int[][] result = new int[k][2];
    while(k > 0) {
      result[--k] = minHeap.remove();
    }
      
    return result;
  }
}

