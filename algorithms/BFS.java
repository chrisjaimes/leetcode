package algorithms;

public class BFS {
  boolean[][] matrix;
  public void bfs(int start) {
    Deque<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[matrix.length];
    
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();

      for (int i = 0; i < matrix.length; i++) {
        if (matrix[node][i] && !visited[i]) {
          queue.add(i);
        }
      }
    }
  }
}