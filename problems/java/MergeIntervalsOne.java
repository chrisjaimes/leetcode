class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1) {
      return intervals;
    }
      
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));   
    LinkedList<int[]> result = new LinkedList<>();
    
    for (int[] interval : intervals) {
      if (result.isEmpty() || interval[0] > result.getLast()[1]) {
        result.add(interval);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
      }
    }
    
    return result.toArray(new int[result.size()][]);
  }
}