public class Solution {
  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid == nums.length - 1) {
        break;
      }
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else if (nums[mid] > nums[mid + 1]) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    
    return left;
  }
}