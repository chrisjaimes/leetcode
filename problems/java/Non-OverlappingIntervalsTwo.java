class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    
    int dp[] = new int[intervals.length];
    dp[0] = 1;
    int result = 1;
    
    for (int i = 1; i < dp.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (intervals[j][1] <= intervals[i][0]) {
          max = Math.max(dp[j], max);
        }
      }
      dp[i] = max + 1;
      result = Math.max(result, dp[i]);
    }
    return intervals.length - result;
  }
}