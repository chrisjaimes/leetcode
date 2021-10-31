class Solution {
  public int minKnightMoves(int x, int y) {
    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, -1}, {-2, 1}};
      
    Deque<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[605][605];
      
    int min = 0;
    queue.add(new int[]{0, 0});
      
    while (!queue.isEmpty()) {
      int size = queue.size();
      
      for (int i = 0; i < size; i++) {
        int[] current = queue.remove();
        
        if (current[0] == x && current[1] == y) {
          return min;
        }
          
        for (int[] move : moves) {
          int[] next = new int[]{ current[0] + move[0], current[1] + move[1] };
            
          if (!visited[next[0] + 302][next[1] + 302]) {
            visited[next[0] + 302][next[1] + 302] = true;
            queue.add(next);
          }
        }
      }
        
      min++;
    }
      
    return min;
  }
}