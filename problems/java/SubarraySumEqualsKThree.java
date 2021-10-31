class Solution {
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int[] sums = new int[nums.length + 1];
    sums[0] = 0;
    for (int i = 1; i <= nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    for (int start = 0; start < nums.length; start++) {
      for (int end = start + 1; end <= nums.length; end++) {
        if (sums[end] - sums[start] == k) {
          count++;
        }
      }
    }
    
    return count;
  }
}