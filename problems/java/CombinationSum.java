class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    generateCombinations(candidates, 0, 0, target, new ArrayList<Integer>(), result);
    return result;
  }

  private void generateCombinations(int[] nums, int sum, int index, int target, List<Integer> current, List<List<Integer>> result) {
    if (sum == target) {
      result.add(current);
      return;
    }
      
    if (sum > target) {
      return;
    }
      
    for (int i = index; i < nums.length; i++) {
      current.add(nums[i]);
      generateCombinations(nums, sum + nums[i], i, target, new ArrayList<>(current), result);
      current.remove(current.size() - 1);
    }
  }
}