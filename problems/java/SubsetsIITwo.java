class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    generateSubsets(nums, 0, new ArrayList<Integer>(), result);
    return result;
  }
  private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    for (int i = index; i < nums.length; i++) {
      if (i != index && nums[i] == nums[i - 1]) {
        continue;
      }
      current.add(nums[i]);
      generateSubsets(nums, i + 1, current, result);
      current.remove(current.size() - 1);
    }
  }
}