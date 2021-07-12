class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    return wordBreakHelper(s, set, 0);
  }
  
  private boolean wordBreakHelper(String s, HashSet<String> set, int start) {
    if (start == s.length()) {
      return true;
    }
      
    for (int end = start + 1; end <= s.length(); end++) {
      if (set.contains(s.substring(start, end)) && wordBreakHelper(s, set, end)) {
        return true;
      }
    }
      
    return false;
  }
}