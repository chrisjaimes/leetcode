class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int count = Integer.MAX_VALUE;
    int start = 0;

    int sum = 0;
    for (int end = 0; end < nums.length; end++) {
      sum += nums[end];
      while (sum >= target) {
        count = Math.min(count, end - start + 1);
        sum -= nums[start];
        start++;
      }
    }

    return (count == Integer.MAX_VALUE) ? 0 : count;
  }
}