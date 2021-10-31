class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = { -1, -1 };
    if (nums == null) return result;
    result[0] = searchLeft(nums, target, 0, nums.length - 1);
    result[1] = searchRight(nums, target, result[0], nums.length - 1);
    return result;
  }

  public int searchLeft(int[] nums, int target, int lo, int hi) {
    if (lo > hi || lo < 0) return -1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] < target) { 
        lo = mid + 1;
      } else { 
        hi = mid;
      }
    }
    return nums[lo] == target ? lo : -1;
  }

  public int searchRight(int[] nums, int target, int lo, int hi) {
    if (lo > hi || lo < 0) return -1;
    if (lo == hi) return nums[lo] == target ? lo : -1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2 + 1;
      if (nums[mid] > target) { 
        hi = mid - 1;
      } else { 
        lo = mid;
      }
    }
    return nums[lo] == target ? lo : -1;
  }
}