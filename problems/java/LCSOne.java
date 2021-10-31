class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    HashMap<String, Integer> memo = new HashMap<>();
    return longestCommonSubsequence(text1, text1.length() - 1, text2, text2.length() - 1, memo);
  }
  
  private int longestCommonSubsequence(String text1, int i, String text2, int j, HashMap<String, Integer> memo) {
    if (i < 0 || j < 0) {
      return 0;
    }
      
    String key = text1.substring(i, text1.length()) + text2.substring(j, text2.length());
      
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
      
    int answer1 = 0;
    int answer2 = 0;
      
    if (text1.charAt(i) == text2.charAt(j)) {
      answer1 = 1 + longestCommonSubsequence(text1, i - 1, text2, j - 1, memo);
    } else {
      answer2 = Math.max(longestCommonSubsequence(text1, i - 1, text2, j, memo), longestCommonSubsequence(text1, i, text2, j - 1, memo));
    }
      
    int answer = Math.max(answer1, answer2);
    
    memo.put(key, answer);
    return memo.get(key);
  }
}