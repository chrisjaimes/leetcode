class Solution {
  int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

  public int longestIncreasingPath(int[][] matrix) {
    int[][] memo = new int[matrix.length][matrix[0].length];
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int max = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        int x = findLIP(matrix, row, col, memo);
        max = Math.max(x, max);
      }
    }
    
    return max;
  }

  private int findLIP(int[][] matrix, int row, int col, int[][] memo) {
    if (memo[row][col] != 0) {
      return memo[row][col];
    }
    
    for (int[] direction : directions) {
      int x = row + direction[0];
      int y = col + direction[1];
      
      if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length && matrix[x][y] > matrix[row][col]) {
        memo[row][col] = Math.max(memo[row][col], findLIP(matrix, x, y, memo));
      }
    }
    
    memo[row][col] = memo[row][col] + 1;
    return memo[row][col];
  }
}