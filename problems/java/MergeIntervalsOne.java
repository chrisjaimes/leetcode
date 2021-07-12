class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals == null) {
      return new int[0][0];
    } else if (intervals.length == 1) {
      return intervals;
    }
      
    LinkedList<int[]> result = new LinkedList<>();
    for (int[] interval : intervals) {
      if (result.isEmpty() || result.getLast()[1] <= interval[0]) {
        result.add(interval);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
      }
    }
      
    return result.toArray(new int[result.size()][]);
  }
}