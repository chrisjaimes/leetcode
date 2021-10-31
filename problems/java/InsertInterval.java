class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    LinkedList<int[]> result = new LinkedList<>();
    
    int index = 0;
    while (index < intervals.length && intervals[index][0] < newInterval[0]) {
      result.add(intervals[index]);
      index++;
    }
    
    if (result.isEmpty() || newInterval[0] > result.getLast()[1]) {
      result.add(newInterval);
    } else {
      int[] temp = new int[] { result.getLast()[0], Math.max(newInterval[1], result.getLast()[1]) };
      result.removeLast();
      result.add(temp);
    }
    
    while (index < intervals.length) {
      if (intervals[index][0] > result.getLast()[1]) {
        result.add(intervals[index]);
      } else {
        int[] temp = new int[] { result.getLast()[0], Math.max(result.getLast()[1], intervals[index][1]) };
        result.removeLast();
        result.add(temp);
      }
      index++;
    }
    
    return result.toArray(new int[result.size()][2]);
  }
}