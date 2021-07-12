class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int r = triangle.size() - 2;
    for (int row = r; row >= 0; row--) {
      for (int col = 0; col <= row; col++) {
        int minAbove = Math.min(
          triangle.get(row + 1).get(col), 
          triangle.get(row + 1).get(col + 1)
        );
        triangle.get(row).set(col, minAbove + triangle.get(row).get(col));
      }
    }
    
    return triangle.get(0).get(0);
  }
}
