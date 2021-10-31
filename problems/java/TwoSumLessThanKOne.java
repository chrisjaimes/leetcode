class Solution {
  public int twoSumLessThanK(int[] nums, int k) {
    Arrays.sort(nums);
    int i = 0;
    int j = nums.length - 1;
    int sum = -1;
    while (i < j) {
      int current = nums[i] + nums[j];
      if (current >= k) {
        j--;
      } else if (current < k) {
        i++;
        sum = Math.max(sum, current);
      }
    }
    return sum;
  }
}