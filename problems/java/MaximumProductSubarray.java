class Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    
    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int product  = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
      int temp = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * minSoFar));
      minSoFar = Math.min(nums[i], Math.min(nums[i] * maxSoFar, nums[i] * minSoFar));
      
      maxSoFar = temp;
      product = Math.max(maxSoFar, product);
    }
    
    return product;
  }
}