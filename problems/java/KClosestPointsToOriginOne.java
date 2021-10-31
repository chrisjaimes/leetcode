class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
      // x^2 + y^2 = sqrt((x^2 - 0) + (y^2 - 0))
      return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
    });
    
    for (int i = 0; i < points.length; i++) {
      maxHeap.add(points[i]);
      if (maxHeap.size() > k) {
        maxHeap.remove();
      }
    }
    
    int[][] result = new int[k][2];
    while(k-- > 0) {
      result[k] = maxHeap.remove();
    }
      
    return result;
  }
}

