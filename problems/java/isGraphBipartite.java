class Solution {
  public boolean isBipartite(int[][] graph) {
    int[] visited = new int[graph.length];
    for (int i = 0; i < visited.length; i++) {
      if (visited[i] == 0) {
        boolean ans = dfs(graph, i, visited, 1, -1);
        if (ans == false) {
          return false;
        }
      }
    }           
    return true;
  }
  
  public boolean dfs(int[][] graph, int src, int[] visited, int color, int parent) {
    visited[src] = color;
    for (int neighbor : graph[src]) {
      if (visited[neighbor] == 0 && !dfs(graph, neighbor, visited, 3 - color, src)) {
        return false;
      } else if (neighbor != parent && visited[neighbor] == color) {
        return false;
      }            
    }
    return true;
  }
}
