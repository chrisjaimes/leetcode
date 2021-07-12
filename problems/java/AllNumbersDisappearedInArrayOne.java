class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<Integer>();
    }
    List<Integer> result = new ArrayList<>();
    
    for (int i = 0; i < nums.length; i++) {
      int indexToMark = Math.abs(nums[i]) - 1;
      int valueAtIndex = Math.abs(nums[indexToMark]);
      nums[indexToMark] = valueAtIndex * -1;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }
    
    return result;
  }
}

