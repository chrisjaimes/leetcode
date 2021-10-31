class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = { -1, -1 };

    result[0] = findTarget(nums, target, true);
    if (result[0] == -1) {
      return result;
    }

    int last = findTarget(nums, target, false);
    result[1] = last;

    return result;
  }

  private int findTarget(int[] nums, int target, boolean firstOcurrence) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (nums[mid] > target) {
        hi = mid - 1;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        if (firstOcurrence) {
          if (mid == lo || nums[mid - 1] != target) {
            return mid;
          }
          
          hi = mid - 1;
        } else {
          if (mid == hi || nums[mid + 1] != target) {
            return mid;
          }
          lo = mid + 1;
        }
      }
    }
    return -1;
  }
}
