class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    
    int subsetSize = 0;
    
    for (int i = 0; i < nums.length; i++) {
      int size = result.size();
      int start = (i > 0 && nums[i] == nums[i - 1]) ? subsetSize: 0;
      subsetSize = result.size();
      for (int j = start; j < subsetSize; j++) {
        int s = result.get(j).size();
        List<Integer> subset = new ArrayList<>(result.get(j));
        subset.add(nums[i]);
        result.add(subset);
      }
    }
      
    return result;
  }
}