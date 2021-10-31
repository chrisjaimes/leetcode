class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int col = 0; col < matrix[0].length; col++) {
      int min = matrix[0][col];
      int max = matrix[matrix.length - 1][col];
      
      boolean targetMin = (target >= min);
      boolean targetMax = (target <= max);
      
      if (target == min || target == max) {
        return true;
      }
      
      if (targetMin && targetMax) {
        if (binarySearch(matrix, target, col, 1, matrix.length)) {
          return true;
        }
      } else if (!targetMin && !targetMax) {
        return false;
      } else if (targetMin && !targetMax) {
        ;
      } else if (!targetMin && targetMax) {
        return false;   
      }
    }
      
    return false;
  }
  
  private boolean binarySearch(int[][] matrix, int target, int col, int lo, int hi) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      
      if (matrix[mid][col] < target) {
        lo = mid + 1;
      } else if (matrix[mid][col] > target) {
        hi = mid - 1;
      } else {
        return true;
      }
    }
      
    return false;
  }
}
