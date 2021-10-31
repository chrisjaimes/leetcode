class Solution {
  public int maximalSquare(char[][] matrix) {
    int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
    
    int res = 0;
    
    for (int i = 1; i <= matrix.length; i++) {
      for (int j = 1; j <= matrix[0].length; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          memo[i][j] = Math.min(
            Math.min(memo[i - 1][j], memo[i][j - 1]),
            memo[i - 1][j - 1]
          ) + 1;
          res = Math.max(res, memo[i][j]);
        }
      }
    }
    
    return res * res;
  }
}