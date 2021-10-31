class Solution {
  public int minFallingPathSum(int[][] matrix) {
    for (int row = 1; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        int temp1 = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;
        int temp3 = Integer.MAX_VALUE;
        
        if (col > 0) {
          temp1 = matrix[row - 1][col - 1];
        }
        temp2 = matrix[row - 1][col];
        if (col < matrix[row].length - 1) {
          temp3 = matrix[row - 1][col + 1];
        }
        
        matrix[row][col] += Math.min(
          Math.min(temp1, temp2),
          temp3
        );
      }
    }
    
    int min = Integer.MAX_VALUE;
    int lastRow = matrix.length - 1;
    for (int i = 0; i < matrix[lastRow].length; i++) {
      min = Math.min(min, matrix[lastRow][i]);
    }
    
    return min;
  }
}