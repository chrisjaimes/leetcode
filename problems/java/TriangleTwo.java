class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> belowRow = triangle.get(triangle.size() - 1);
    int r = triangle.size() - 2;
    for (int row = r; row >= 0; row--) {
      List<Integer> currentRow = new ArrayList<>();
      for (int col = 0; col <= row; col++) {
        int minBelow = Math.min(
          belowRow.get(col), 
          belowRow.get(col + 1)
        );
        currentRow.add(minBelow + triangle.get(row).get(col));
      }
      belowRow = currentRow;
    }
    
    return belowRow.get(0);
  }
}
