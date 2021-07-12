class Solution {
  public int climbStairs(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } 
      
    return climbStairs(n, new HashMap<Integer, Integer>());
  }
  private int climbStairs(int n, HashMap<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
      return 1;
    }
    
    if (memo.containsKey(n)) {
      return memo.get(n);
    } else {
      memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
    }
      
    return memo.get(n);
  }
}