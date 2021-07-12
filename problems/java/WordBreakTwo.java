class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    Boolean[] memo = new Boolean[s.length()];
    return wordBreakHelper(s, set, 0, memo);
  }
  
  private boolean wordBreakHelper(String s, HashSet<String> set, int start, Boolean[] memo) {
    if (start == s.length()) {
      return true;
    }
      
    if (memo[start] != null) {
      return memo[start];
    }
      
    for (int end = start + 1; end <= s.length(); end++) {
      if (set.contains(s.substring(start, end)) && wordBreakHelper(s, set, end, memo)) {
        memo[start] = true;
        return true;
      }
    }
      
    memo[start] = false;
    return false;
  }
}