class Solution {
  public boolean validTree(int n, int[][] edges) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < edges.length; i++) {
      map.get(edges[i][0]).add(edges[i][1]);
      map.get(edges[i][1]).add(edges[i][0]);
    }

    boolean[] visited = new boolean[n];
    if (!dfs(0, map, visited, -1)) {
      return false;
    }

    for (int i = 0; i< visited.length; i++) {
      if (visited[i] == false) {
        return false;
      }
    }

    return true;
  }

  private boolean dfs(int node, HashMap<Integer, List<Integer>> map, boolean[] visited, int parent) {
    if (visited[node]) {
      return false;
    }

    visited[node] = true;
    for (int i = 0; i < map.get(node).size(); i++) {
      int neighbor = map.get(node).get(i);
      if (parent != neighbor && !dfs(neighbor, map, visited, node)) {
        return false;
      }
    }

    return true;
  }
}