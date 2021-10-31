class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    if (text1 == null || text1.isEmpty()) {
      return 0;
    } else if (text2 == null || text2.isEmpty()) {
      return 0;
    }
      
    int[][] matrix = new int[text1.length() + 1][text2.length() + 1];
      
    for (int i = 1; i <= text1.length(); i++) {
      for (int j = 1; j <= text2.length(); j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          matrix[i][j] = 1 + matrix[i - 1][j - 1];
        } else {
          matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);   
        }
      }
    }
      
    return matrix[text1.length()][text2.length()];
  }
}