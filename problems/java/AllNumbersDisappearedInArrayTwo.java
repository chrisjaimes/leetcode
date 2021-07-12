class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<Integer>();
    }
    int[] freqs = new int[nums.length];
    List<Integer> result = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length; i++) {
      freqs[nums[i] - 1]++;
    }
    for (int i = 0; i < nums.length; i++) {
      if (freqs[i] == 0) {
        result.add(i + 1);
      }
    }
    
    return result;
  }
}