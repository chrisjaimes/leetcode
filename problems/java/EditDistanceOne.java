class Solution {
  public int minDistance(String word1, String word2) {
    if (word1.length() == 0) {
      return word2.length();
    }
    if (word2.length() == 0) {
      return word1.length();
    }
      
    int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = i;
    }
    for (int i = 0; i < matrix[0].length; i++) {
      matrix[0][i] = i;
    }
      
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          matrix[i][j] = matrix[i - 1][j - 1];
        } else {
          matrix[i][j] = Math.min(
            Math.min(
              1 + matrix[i - 1][j],
              1 + matrix[i][j - 1]
            ),
            1 + matrix[i - 1][j - 1]
          );
        }
      }
    }
      
    return matrix[matrix.length - 1][matrix[0].length - 1];
  }
}