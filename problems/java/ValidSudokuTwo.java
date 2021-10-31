class Solution {
  public boolean isValidSudoku(char[][] board) {
    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[] boxes = new HashSet[9];
    
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<Character>();
      cols[i] = new HashSet<Character>();
      boxes[i] = new HashSet<Character>();
    }
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];
        if (c == '.') {
          continue;
        }
        
        if (rows[i].contains(c)) {
          return false;
        } else {
          rows[i].add(c);
        }
        
        if (cols[i].contains(c)) {
          return false;
        } else {
          cols[i].add(c);
        }
        
        int box = (i / 3) * 3 + (j / 3);
        if (boxes[box].contains(c)) {
          return false;
        } else {
          boxes[box].add(c);
        }
      }
    }
    
    return true;
  }
}