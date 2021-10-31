class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) {
      return false;
    }
    int n = matrix[0].length;

    int left = 0;
    int right = m * n - 1;
    int pivotIndex;
    int pivotElement;

    while (left <= right) {
      pivotIndex = left + (right - left) / 2;
      pivotElement = matrix[pivotIndex / n][pivotIndex % n];

      if (target < pivotElement) {
        right = pivotIndex - 1;
      } else if (target > pivotElement) {
        left = pivotIndex + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}