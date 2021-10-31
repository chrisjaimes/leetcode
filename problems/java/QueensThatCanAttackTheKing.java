class Solution {
  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    boolean[][] queenPositions = new boolean[8][8];
    for (int[] q : queens) {
      queenPositions[q[0]][q[1]] = true;
    }

    List<List<Integer>> result = new ArrayList<>();
    int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1} };

    for (int i = 0; i < directions.length; i++) {
      int x = king[0] + directions[i][0];
      int y = king[1] + directions[i][1];

      while (x >= 0 && x < 8 && y >= 0 && y < 8) {
        if (queenPositions[x][y]) {
          List<Integer> position = new ArrayList<>();
          position.add(x);
          position.add(y);
          result.add(position);
          break;
        }
        x += directions[i][0];
        y += directions[i][1];
      }
    }

    return result;
  }
}