class Solution {
  public int countComponents(int n, int[][] edges) {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Integer>());
    }
      
    for (int i = 0; i < edges.length; i++) {
      graph.get(edges[i][0]).add(edges[i][1]);
      graph.get(edges[i][1]).add(edges[i][0]);
    }
      
    boolean[] visited = new boolean[n];
    
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, graph, visited);
        count++;
      }
    }
      
      return count;
  }
  
  private void dfs(int node, HashMap<Integer, List<Integer>> map, boolean[] visited) {
    visited[node] = true;
      
    for (int neighbor : map.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, map, visited);
      }
    }
  }
}