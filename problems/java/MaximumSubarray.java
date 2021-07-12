class Solution {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int maxSoFar = 0;

    for (int i = 0; i < nums.length; i++) {
      maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
      max = Math.max(maxSoFar, max);
    }
    
    return max;
  }
}