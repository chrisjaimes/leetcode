class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    boolean[] memo = new boolean[s.length() + 1];
    memo[0] = true;
    
    for (int end = 1; end <= s.length(); end++) {
      for (int start = 0; start < end; start++) {
        if (memo[start] && set.contains(s.substring(start, end))) {
          memo[end] = true;
        }
      }
    }
    
    return memo[s.length()];
  }
}