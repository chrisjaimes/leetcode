class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int start = 0;
    int max = 0;
    int zeroes = 0;
    
    for (int end = 0; end < nums.length; end++) {
      if (nums[end] == 0) {
        zeroes++;
      }
      
      while (zeroes > 1) {
        if (nums[start] == 0) {
          zeroes--;
        }
        start++;
      }
      
      max = Math.max(max, end - start + 1);
    }
    
    return max;
  }
}