class Solution {
  public boolean canJump(int[] nums) {
    boolean[] matrix = new boolean[nums.length];
    matrix[0] = true;
      
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (matrix[j] && (j + nums[j] >= i)) {
          matrix[i] = true;
          break;
        }
      }
    }
    return matrix[nums.length - 1];
  }
}