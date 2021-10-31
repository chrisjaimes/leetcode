package algorithms;

public class DFS {
  boolean[][] matrix;
  public void dfs(int start) {
    boolean[] visited = new boolean[matrix.length];
    dfs(start, visited);
  }

  public void dfs(int node, boolean[] visited) {
    visited[node] = true;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[node][i] && !visited[i]) {
        dfs(i, visited);
      }
    }
  }
}
