class Solution {
  public int totalNQueens(int n) {
    return backtrack(n, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
  }
  
  public int backtrack(int n, int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
    if (row == n) {
      return 1;
    }
    
    int solutions = 0;
    for (int col = 0; col < n; col++) {
      int currentDiagonal = row - col;
      int currentAntiDiagonal = row + col;
      
      if (cols.contains(col) 
        || diagonals.contains(currentDiagonal) 
        || antiDiagonals.contains(currentAntiDiagonal)
      ) {
        continue;
      }
      
      cols.add(col);
      diagonals.add(currentDiagonal);
      antiDiagonals.add(currentAntiDiagonal);
      solutions += backtrack(n, row + 1, diagonals, antiDiagonals, cols);
      cols.remove(col);
      diagonals.remove(currentDiagonal);
      antiDiagonals.remove(currentAntiDiagonal);
    }
    
    return solutions;
  }
}