public class Solution {
  public int findPeakElement(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      
      if (mid == nums.length - 1) {
        break;
      }
      
      if (nums[mid] > nums[mid + 1]) {
        hi = mid - 1;
      } else if (nums[mid] < nums[mid + 1]) {
        lo = mid + 1;
      }
    }
    
    return lo;
  }
}