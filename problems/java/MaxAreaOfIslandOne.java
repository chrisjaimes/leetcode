class Solution {
  public int maxAreaOfIsland(int[][] grid) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, maxAreaOfIsland(grid, i, j));
        }
      }
    }
      
    return max;
  }
  
  private int maxAreaOfIsland(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
      return 0;
    } 
    
    grid[i][j] = 0;
    int count = 1;
    count += maxAreaOfIsland(grid, i + 1, j);
    count += maxAreaOfIsland(grid, i, j + 1);
    count += maxAreaOfIsland(grid, i - 1, j);
    count += maxAreaOfIsland(grid, i, j - 1);
    
    return count;
  }
}