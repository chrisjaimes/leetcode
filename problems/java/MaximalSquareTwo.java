class Solution {
  public int maximalSquare(char[][] matrix) {
    Integer[][] memo = new Integer[matrix.length][matrix[0].length];
    
    int res = 0;
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          res = Math.max(res, dfs(matrix, i, j, memo));
        }
      }
    }
    
    return res * res;
  }
  
  private int dfs(char[][] matrix, int i, int j, Integer[][] memo) {
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
      return 0;
    } else if (matrix[i][j] == '0') {
      return 0;
    }
    
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    
    memo[i][j] = 1 + Math.min(Math.min(dfs(matrix, i + 1, j, memo), dfs(matrix, i, j + 1, memo)), dfs(matrix, i + 1, j + 1, memo));
    
    return memo[i][j];
  }
}