class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    generateCombinations(k, n, 1, new ArrayList<Integer>(), result);
    return result;
  }
  
  private void generateCombinations(int k, int n, int x, List<Integer> current, List<List<Integer>> result) {
    if (current.size() > k || n < 0) {
      return;
    } else if (current.size() == k && n == 0) {
      result.add(current);
      return;
    }
    
    for (int i = x; i < 10; i++) {
      current.add(i);
      generateCombinations(k, n - i, i + 1, new ArrayList<Integer>(current), result);
      current.remove(current.size() - 1);
    }
  }
}