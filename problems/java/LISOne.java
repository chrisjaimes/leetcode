class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } 
      
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
      
    int max = 1;
    for (int right = 1; right < nums.length; right++) {
      for (int left = 0; left < right; left++) {
        if (nums[left] < nums[right]) {
          dp[right] = Math.max(dp[right], dp[left] + 1);
        }
      }
      max = Math.max(max, dp[right]);
    }
    return max;
  }
}