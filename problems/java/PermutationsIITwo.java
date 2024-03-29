class Solution {
  public void backtrack(int n,
                        ArrayList<Integer> nums,
                        List<List<Integer>> output,
                        int first, Set set) {
    // if all integers are used up
    if (first == n && !set.contains(new ArrayList<Integer>(nums))) {
      set.add(new ArrayList<Integer>(nums));
      output.add(new ArrayList<Integer>(nums));
    } else if (first == n) {
      return;
    }
    for (int i = first; i < n; i++) {
      // place i-th integer first 
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1, set);
      // backtrack
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList();

    Set<List<Integer>> set = new HashSet<>();
    
    // convert nums into list since the output is a list of lists
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for (int num : nums)
      nums_lst.add(num);

    int n = nums.length;
    backtrack(n, nums_lst, output, 0, set);
    return output;
  }
}