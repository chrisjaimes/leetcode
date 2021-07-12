class Solution {
  public void rotate(int[][] matrix) {
    transposeDiagonals(matrix);
    reflect(matrix);
  }
  private void transposeDiagonals(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
  private void reflect(int[][] matrix) {
    int lo = 0;
    int hi = matrix.length - 1;
    for (int i = 0; i < matrix.length; i++) {
      while (lo < hi) {
        int temp = matrix[i][lo];
        matrix[i][lo] = matrix[i][hi];
        matrix[i][hi] = temp;
        lo++;
        hi--;
      }
      lo = 0;
      hi = matrix.length - 1;
    }
  }
}