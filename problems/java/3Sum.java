class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int current = 0;
    Arrays.sort(nums);
    while (current <= nums.length - 3) {
      int lo = current + 1;
      int hi = nums.length - 1;

      if (current == 0 || nums[current - 1] != nums[current]) { 
        while (lo < hi) {
          if (nums[current] + nums[lo] + nums[hi] == 0) {
            result.add(Arrays.asList(nums[current], nums[lo++], nums[hi--]));
            while (lo < hi && nums[lo] == nums[lo - 1]) {
              lo++;
            }
          } else if (nums[current] + nums[lo] + nums[hi] > 0) {
            hi--;
          } else if (nums[current] + nums[lo] + nums[hi] < 0) {
            lo++;
          }
        }
      }
      current++;
    }
    return result;
  }
}