class Solution {
  HashSet<List<Integer>> set = new HashSet<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> numsList = new ArrayList<>();
    for (int n : nums) {
      numsList.add(n);
    }
    permute(numsList, new ArrayList<>(), result);
    return result;
  }
  private void permute(List<Integer> nums, List<Integer> current, List<List<Integer>> result) {
    if (nums.size() == 0 && current.size() > 0 && !set.contains(current)) {
      result.add(current);
      set.add(current);
      return;
    }
      
    for (int i = 0; i < nums.size(); i++) {
      List<Integer> newArray = new ArrayList<>(nums);
      newArray.remove(i);
      List<Integer> newPermutation = new ArrayList<>(current);
      newPermutation.add(nums.get(i));
      permute(newArray, newPermutation, result);
    }
  }
}