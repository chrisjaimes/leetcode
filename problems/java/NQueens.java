class Solution {
  char[][] board;
  List<List<String>> solutions = new ArrayList<>();
  public List<List<String>> solveNQueens(int n) {
    board = new char[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    return solutions;
  }
  
  private void backtrack(int n, int row, HashSet<Integer> cols, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals) {
    if (row == n) {
      addSolution(n);
      return;
    }
      
    for (int col = 0; col < n; col++) {
      int currentDiagonal = row - col;
      int currentAntiDiagonal = row + col;

      if (cols.contains(col) || diagonals.contains(currentDiagonal) || antiDiagonals.contains(currentAntiDiagonal)
      ) {
        continue;
      }
          
      cols.add(col);
      diagonals.add(currentDiagonal);
      antiDiagonals.add(currentAntiDiagonal);
      board[row][col] = 'Q';
      
      backtrack(n, row + 1, cols, diagonals, antiDiagonals);
      
      cols.remove(col);
      diagonals.remove(currentDiagonal);
      antiDiagonals.remove(currentAntiDiagonal);
      board[row][col] = '.';
    }
  }
  
  private void addSolution(int n) {
    List<String> solution = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      String r = new String(board[row]);
      solution.add(r);
    }
    solutions.add(solution);
  }
}